import java.util.concurrent.*;
import java.util.List;

public class CentralUnit {
    public CentralUnit(Airbus airbus)
    {
        this.airbus = airbus;
    }
    private final Airbus airbus;
    private int countMessageNormal = 0;
    private int countMessageWarning = 0;
    private int countMessageAlarm = 0;

    public void BlinkLights()
    {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        airbus.getAntiCollisionLight().forEach(antiCollisionLight -> {
            scheduledExecutorService.scheduleAtFixedRate(antiCollisionLight::blink, 0, 3, TimeUnit.SECONDS);
        });
    }

    public void LoadCargo(Storage storage, List<Container> containers)
    {
        for (CargoRobot robot : airbus.getCargoRobots()) {
            robot.setContainers(containers);
            robot.setStorage(storage);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(airbus.getCargoRobots().size());
        try {
            airbus.getCargoRobots().forEach(robot -> {
                executorService.submit(robot::load);
            });
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Cargo loading complete");
        }
    }

    public void StartLaunchSequence() {
        CyclicBarrier doorBarrier = new CyclicBarrier(4 + 1);
        CyclicBarrier engineBarrier = new CyclicBarrier(2 + 1, () -> {
            System.out.println("Ready for taxi");
        });

        for (EntranceDoor entranceDoor : airbus.getEntranceDoors()) {
            new Thread(() -> {
                entranceDoor.Close();
                try {
                    doorBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        try {
            doorBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        for (Engine engine : airbus.getEngines()) {
            new Thread(() -> {
                engine.start();
                try {
                    engineBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

        try {
            engineBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReadSensors()
    {
        Semaphore semaphore = new Semaphore(100);
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        try {
            for (Sensor sensor : airbus.getSensors())
            {
                executorService.submit(() -> {
                    try {
                        semaphore.acquire();
                        switch (sensor.getSensorStatus())
                        {
                            case Normal:
                                countMessageNormal++;
                                break;
                            case Warning:
                                countMessageWarning++;
                                break;
                            case Alarm:
                                countMessageAlarm++;
                                break;
                        }
                        semaphore.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        } finally {
            executorService.shutdown();


            System.out.println("Sensors reporting normal: " + countMessageNormal);
            System.out.println("Sensors reporting warnings: " + countMessageWarning);
            System.out.println("Sensors reporting alarms: " + countMessageAlarm);
        }
    }

}
