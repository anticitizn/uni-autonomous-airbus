
import java.util.Random;
public class Engine {
    Random rand = new Random();
    private boolean isRunning = false;

    public void turnOn() {
        isRunning = true;
    }

    public void turnOff() {
        isRunning = false;
    }

    public void start() {
        try {
            Thread.sleep((rand.nextInt(4) + 1) * 1000);
            turnOn();
            System.out.println("Engine on");
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

}
