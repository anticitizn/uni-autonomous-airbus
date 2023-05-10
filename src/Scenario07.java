
import java.util.ArrayList;
import java.util.List;

public class Scenario07 extends BaseScenario {

    public Scenario07() {
        super();
    }

    public void start() {
        try {
            airbusA350.getCentralUnit().Scan();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
