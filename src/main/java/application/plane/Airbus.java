package application.plane;

import application.humans.Passenger;
import application.robot.CabinRobot;
import application.robot.CargoRobot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

public class Airbus {
    public final AtomicInteger totalNumberOfPassengers = new AtomicInteger();
    private final ArrayList<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
    private final List<CabinRobot> cabinRobots = new ArrayList<>();
    private final List<CargoRobot> cargoRobots = new ArrayList<>();
    private final CentralUnit centralUnit = new CentralUnit(this);
    private final List<EntranceDoor> entranceDoors = new ArrayList<>();
    private final List<Engine> engines = new ArrayList<>();
    private final List<Sensor> sensors = new ArrayList<>();
    private final List<Wing> wings = new ArrayList<>();
    private final List<LandingGear> landingGears = new ArrayList<>();
    private final Processor processor;
    private final Radar radar;
    List<AntiCollisionLight> antiCollisionLight = new ArrayList<AntiCollisionLight>();

    public Airbus() {
        int tempSeatNumber = 0;
        for (int i = 0; i < 42; i++) {
            seats.add(new ArrayList<Seat>());
            for (int j = 0; j < 6; j++) {
                seats.get(i).add(new Seat(new Passenger()));
                tempSeatNumber++;
            }
        }

        this.cabinRobots.add(new CabinRobot(this, new ArrayList<ArrayList<Seat>>(seats.subList(0, 3))));
        this.cabinRobots.add(new CabinRobot(this, new ArrayList<ArrayList<Seat>>(seats.subList(3, 6))));
        this.cabinRobots.add(new CabinRobot(this, new ArrayList<ArrayList<Seat>>(seats.subList(6, 8))));
        this.cabinRobots.add(new CabinRobot(this, new ArrayList<ArrayList<Seat>>(seats.subList(8, 15))));
        this.cabinRobots.add(new CabinRobot(this, new ArrayList<ArrayList<Seat>>(seats.subList(15, 26))));
        this.cabinRobots.add(new CabinRobot(this, new ArrayList<ArrayList<Seat>>(seats.subList(26, 34))));
        this.cabinRobots.add(new CabinRobot(this, new ArrayList<ArrayList<Seat>>(seats.subList(34, 42))));

        this.antiCollisionLight.add(new AntiCollisionLight(Position.Top));
        this.antiCollisionLight.add(new AntiCollisionLight(Position.Bottom));

        for (int i = 0; i < 5; i++) {
            this.cargoRobots.add(new CargoRobot());
        }

        for (int i = 0; i < 4; i++) {
            entranceDoors.add(new EntranceDoor());
        }

        for (int i = 0; i < 2; i++) {
            engines.add(new Engine());
        }

        for (int i = 0; i < 500; i++) {
            sensors.add(new Sensor());
        }

        for (int i = 0; i < 2; i++) {
            wings.add(new Wing());
        }

        for (int i = 0; i < 3; i++) {
            landingGears.add(new LandingGear());
        }

        Exchanger exchanger = new Exchanger();
        processor = new Processor(exchanger);
        radar = new Radar(exchanger);
    }

    public void CountPassengers() {
        for (CabinRobot robot : cabinRobots) {
            robot.countPassengers();
        }
    }

    public CentralUnit getCentralUnit() {
        return centralUnit;
    }

    public List<CargoRobot> getCargoRobots() {
        return cargoRobots;
    }

    public List<EntranceDoor> getEntranceDoors() {
        return entranceDoors;
    }

    public List<Engine> getEngines() {
        return engines;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public List<Wing> getWings() {
        return wings;
    }

    public List<LandingGear> getLandingGears() {
        return landingGears;
    }

    public List<AntiCollisionLight> getAntiCollisionLight() {
        return antiCollisionLight;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Radar getRadar() {
        return radar;
    }

    public List<CabinRobot> getCabinRobots() {
        return cabinRobots;
    }

}