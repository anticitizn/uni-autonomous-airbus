import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class CentralUnit {
    public CentralUnit(Airbus airbus)
    {
        this.airbus = airbus;
    }
    private final Airbus airbus;

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

    public void StartLaunchSequence()
    {

    }
}
