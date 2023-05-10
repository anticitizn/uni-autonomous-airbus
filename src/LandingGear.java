import java.util.Random;

public class LandingGear {
    private boolean isDown = false;
    private Random rand = new Random();

    public void Lower()
    {
        try {
            Thread.sleep((rand.nextInt(3) + 1) * 1000);
            isDown = true;
            System.out.println("Landing gear lowered");
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
