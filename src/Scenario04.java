
import java.util.ArrayList;
import java.util.List;

public class Scenario04 extends BaseScenario {

    public Scenario04() {
        super();
    }

    public void start() {
        try {
            airbusA350.getCentralUnit().StartLaunchSequence();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
