package application.plane;

import java.util.Random;

public class Sensor {
    private final SensorStatus sensorStatus;
    Random rand = new Random();

    public Sensor() {
        SensorStatus[] sensorStatuses = SensorStatus.values();

        int randomIndex = rand.nextInt(sensorStatuses.length);
        sensorStatus = sensorStatuses[randomIndex];
    }

    public SensorStatus getSensorStatus() {
        return sensorStatus;
    }
}
