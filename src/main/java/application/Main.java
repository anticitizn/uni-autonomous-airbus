package application;

import application.scenario.ScenarioExecutor;

public class Main {
    public static void main(String[] args) {
        ScenarioExecutor scenarioExecutor = new ScenarioExecutor();
        try {
            scenarioExecutor.run();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}