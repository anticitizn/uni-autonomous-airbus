package application.plane;

import java.util.ArrayList;
import java.util.List;

public class Wing {
    List<Flap> flaps = new ArrayList<Flap>();

    public Wing() {
        for (int i = 0; i < 2; i++) {
            flaps.add(new Flap());
        }
    }

    public List<Flap> getFlaps() {
        return flaps;
    }
}
