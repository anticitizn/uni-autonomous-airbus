package application.scenario;

import application.humans.DEA;
import application.utils.Logger;

public class Scenario09 extends BaseScenario {

    public Scenario09() {
        super();
    }

    public void start() {
        try {
            Logger.setFilename("scenario_09.log");
            Logger.log("Scanning passenger faces, this may take a while...");
            DEA dea = new DEA(airbusA350.getCabinRobots());
            Logger.log("Is El Chapo on board: " + dea.isElChapoOnBoard());
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
