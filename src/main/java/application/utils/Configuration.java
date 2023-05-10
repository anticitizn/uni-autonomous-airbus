package application.utils;

import application.scenario.*;

public enum Configuration {
    INSTANCE;

    public final BaseScenario scenario = new Scenario01();
}
