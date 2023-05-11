package application.plane;

import application.utils.Logger;

import java.util.Random;
import java.util.concurrent.Phaser;

public class Engine {
    Random rand = new Random();
    private boolean isRunning = false;
    private int rpm = 0;
    private Phaser phaser;

    public void turnOn() {
        isRunning = true;
    }
    public void setPhaser(Phaser phaser)
    {
        this.phaser = phaser;
    }

    public void turnOff() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public int getRpm() {
        return rpm;
    }

    public void start() {
        try {
            Thread.sleep((rand.nextInt(4) + 1) * 1000);
            turnOn();
            Logger.log("Engine on");
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    public void startPhased() {
        try {
            turnOn();
            Thread.sleep(3000);
            rpm = 500;
            Logger.log("Engine RPM set to 500");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(3000);
            rpm = 2400;
            Logger.log("Engine RPM set to 2400");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(3000);
            rpm = 4400;
            Logger.log("Engine RPM set to 4400");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(3000);
            rpm = 6000;
            Logger.log("Engine RPM set to 6000");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}
