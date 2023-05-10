
import java.util.ArrayList;
import java.util.List;

public class Scenario02 extends BaseScenario {

    public Scenario02() {
        super();
    }

    public void start() {
        try {
            Logger.setFilename("scenario_02.log");
            Logger.log("Anti-collision lights enabled");
            airbusA350.getCentralUnit().BlinkLights();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
