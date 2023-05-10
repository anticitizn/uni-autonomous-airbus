
import java.util.ArrayList;
import java.util.List;

public class Scenario06 extends BaseScenario {

    public Scenario06() {
        super();
    }

    public void start() {
        try {
            Logger.setFilename("scenario_06.log");
            Logger.log("Landing initiated");
            airbusA350.getCentralUnit().Land();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
