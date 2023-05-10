public class Engine {

    protected Position position;
    protected boolean isRunning;

    public Engine(Position position) {
        super();
        this.position = position;
        this.isRunning = false;
    }

    public void turnOn() {
        isRunning = true;
    }

    public void turnOff() {
        isRunning = false;
    }

}
