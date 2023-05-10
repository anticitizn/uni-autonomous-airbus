import java.util.Random;

public class Sensor {
    Random rand = new Random();
    private final SensorStatus sensorStatus;
    public Sensor()
    {
        SensorStatus[] sensorStatuses = SensorStatus.values();

        int randomIndex = rand.nextInt(sensorStatuses.length);
        sensorStatus = sensorStatuses[randomIndex];
    }

    public SensorStatus getSensorStatus() {
        return sensorStatus;
    }
}
