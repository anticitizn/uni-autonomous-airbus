package application.plane;

import java.util.ArrayList;
import java.util.List;

public class Wing {
    public Wing()
    {
        for (int i = 0; i < 2; i++)
        {
            flaps.add(new Flap());
        }
    }

    public List<Flap> getFlaps() {
        return flaps;
    }

    List<Flap> flaps = new ArrayList<Flap>();
}
