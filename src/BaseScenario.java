
public abstract class BaseScenario{
    protected Airbus airbusA350;

    public BaseScenario() {
        this.airbusA350 = new Airbus();
    }

    public abstract void start();

    public void setAirbusA350(Airbus airbusA350) {
        this.airbusA350 = airbusA350;
    }
}
