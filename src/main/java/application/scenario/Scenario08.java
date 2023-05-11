package application.scenario;

import application.utils.Logger;

public class Scenario08 extends BaseScenario {

    public Scenario08() {
        super();
    }

    public void start() {
        try {
            Logger.setFilename("scenario_08.log");
            Logger.log("Phased engine sequence initiated");
            airbusA350.getCentralUnit().StartEngines();
            Logger.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
