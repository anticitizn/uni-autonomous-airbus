package application.scenario;

import application.utils.Configuration;

public class ScenarioExecutor {

    public void run() throws InterruptedException {
        internalRun();
    }

    private void internalRun() {
        try {
            Configuration.INSTANCE.scenario.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println("lol");
        }
    }
}
