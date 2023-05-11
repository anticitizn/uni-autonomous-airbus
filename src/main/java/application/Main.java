package application;

import application.scenario.ScenarioExecutor;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
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