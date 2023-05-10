
import java.util.ArrayList;
import java.util.List;

public class Scenario09 extends BaseScenario {

    public Scenario09() {
        super();
    }

    public void start() {
        try {
            System.out.println("Scanning passenger faces, this may take a while...");
            DEA dea = new DEA(airbusA350.getCabinRobots());
            System.out.println("Is El Chapo on board: " + dea.isElChapoOnBoard);
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
