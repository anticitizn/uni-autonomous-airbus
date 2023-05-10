
import java.util.Random;
public class EntranceDoor {
    Random rand = new Random();
    private boolean open = true;

    public void Close()
    {
        try {
            Thread.sleep((rand.nextInt(3) + 1) * 1000);
            open = false;
            Logger.log("Door closed");
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
