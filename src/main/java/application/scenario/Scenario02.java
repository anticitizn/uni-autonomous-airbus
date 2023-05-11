package application.scenario;

import application.utils.Logger;

public class Scenario02 extends BaseScenario {

    public Scenario02() {
        super();
    }

    public void start() {
        try {
            Logger.setFilename("scenario_02.log");
            Logger.log("Anti-collision lights enabled");
            airbusA350.getCentralUnit().BlinkLights();
            Logger.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
