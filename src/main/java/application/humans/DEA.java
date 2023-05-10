package application.humans;

import application.robot.CabinRobot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class DEA {
    boolean isElChapoOnBoard = false;
    private List<Future<AtomicBoolean>> futures = new ArrayList<>();

    public boolean isElChapoOnBoard() {
        return isElChapoOnBoard;
    }

    public DEA(List<CabinRobot> robotsList) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            this.futures = executorService.invokeAll(robotsList, 30, TimeUnit.SECONDS);
            executorService.shutdown();
            updateElChapoOnBoard();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateElChapoOnBoard() {
        for (Future<AtomicBoolean> future : futures) {
            try {
                if (future.get().get()) {
                    isElChapoOnBoard = true;
                    break;
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
