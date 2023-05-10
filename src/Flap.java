public class Flap {
    private boolean isDown = false;

    public void Lower()
    {
        isDown = true;
        Logger.log("Flap lowered");
    }
}
