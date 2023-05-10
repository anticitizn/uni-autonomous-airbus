package application.plane;

import application.utils.Logger;

public class Flap {
    private boolean isDown = false;

    public void Lower()
    {
        isDown = true;
        Logger.log("Flap lowered");
    }

    public boolean isDown() {
        return isDown;
    }
}
