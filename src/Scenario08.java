
import java.util.ArrayList;
import java.util.List;

public class Scenario08 extends BaseScenario {

    public Scenario08() {
        super();
    }

    public void start() {
        try {
            airbusA350.getCentralUnit().StartEngines();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
