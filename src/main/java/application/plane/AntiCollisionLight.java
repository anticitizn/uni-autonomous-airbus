package application.plane;

import application.utils.Logger;

public class AntiCollisionLight {
    private final Position position;
    private boolean isOn = false;

    public AntiCollisionLight(Position position) {
        this.position = position;
    }

    public void on() {
        isOn = true;
    }

    public void off() {
        isOn = false;
    }

    public void switchState() {
        isOn = !isOn;
    }

    public void blink() {
        Logger.log(position.name() + " light blinking!");
        on();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        off();
    }
}
