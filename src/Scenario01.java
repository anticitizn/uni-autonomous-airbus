
import java.util.ArrayList;
import java.util.List;

public class Scenario01 extends BaseScenario {

    public Scenario01() {
        super();
    }

    public void start() {
        try {
            airbusA350.CountPassengers();
            Thread.sleep(2000);
            System.out.println(airbusA350.totalNumberOfPassengers);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
