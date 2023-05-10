
import java.util.ArrayList;
import java.util.List;

public class Scenario05 extends BaseScenario {

    public Scenario05() {
        super();
    }

    public void start() {
        try {
            airbusA350.getCentralUnit().ReadSensors();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
