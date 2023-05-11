package application.scenario;

import application.utils.Logger;

public class Scenario07 extends BaseScenario {

    public Scenario07() {
        super();
    }

    public void start() {
        try {
            Logger.setFilename("scenario_07.log");
            airbusA350.getCentralUnit().Scan();
            Logger.close();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
