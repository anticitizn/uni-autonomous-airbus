
import java.util.ArrayList;
import java.util.List;

public class Scenario07 extends BaseScenario {

    public Scenario07() {
        super();
    }

    public void start() {
        try {
            Logger.setFilename("scenario_07.log");
            airbusA350.getCentralUnit().Scan();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
