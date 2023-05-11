package application.scenario;

import application.utils.Logger;

public class Scenario04 extends BaseScenario {

    public Scenario04() {
        super();
    }

    public void start() {
        try {
            Logger.setFilename("scenario_04.log");
            Logger.log("Launch sequence started");
            airbusA350.getCentralUnit().StartLaunchSequence();
            Logger.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
