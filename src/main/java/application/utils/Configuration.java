package application.utils;

import application.scenario.BaseScenario;
import application.scenario.Scenario01;

public enum Configuration {
    INSTANCE;

    public final BaseScenario scenario = new Scenario01();
}
