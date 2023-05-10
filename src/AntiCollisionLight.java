public class AntiCollisionLight {
    private boolean isOn = false;
    private Position position;
    public AntiCollisionLight(Position position)
    {
        this.position = position;
    }

    public void on()
    {
        isOn = true;
    }

    public void off()
    {
        isOn = false;
    }

    public void switchState()
    {
        isOn = !isOn;
    }

    public void blink()
    {
        System.out.println("Light blinking!");
        on();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        off();
    }
}
