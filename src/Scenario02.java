
import java.util.ArrayList;
import java.util.List;

public class Scenario02 extends BaseScenario {

    public Scenario02() {
        super();
    }

    public void start() {
        try {
            airbusA350.getCentralUnit().BlinkLights();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
