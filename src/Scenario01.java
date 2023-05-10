
import java.util.ArrayList;
import java.util.List;

public class Scenario01 extends BaseScenario {

    public Scenario01() {
        super();
    }

    public void start() {
        try {
            Logger.setFilename("scenario_01.log");
            Logger.log("Passenger count started");
            airbusA350.CountPassengers();
            Thread.sleep(2000);
            Logger.log("Total number of passengers: " + airbusA350.totalNumberOfPassengers.toString());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
