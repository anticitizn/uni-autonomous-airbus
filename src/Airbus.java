import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Airbus {
    public Airbus()
    {
        for (int i = 0; i < 42; i++)
        {
            seats.add(new ArrayList<Seat>());
            for (int j = 0; j < 6; j++)
            {
                seats.get(i).add(new Seat());
            }
        }

        robots.add(new Robot(this, (ArrayList<ArrayList<Seat>>)seats.subList(0, 2)));
        robots.add(new Robot(this, (ArrayList<ArrayList<Seat>>)seats.subList(3, 5)));
        robots.add(new Robot(this, (ArrayList<ArrayList<Seat>>)seats.subList(6, 7)));
        robots.add(new Robot(this, (ArrayList<ArrayList<Seat>>)seats.subList(8, 14)));
        robots.add(new Robot(this, (ArrayList<ArrayList<Seat>>)seats.subList(15, 25)));
        robots.add(new Robot(this, (ArrayList<ArrayList<Seat>>)seats.subList(26, 33)));
        robots.add(new Robot(this, (ArrayList<ArrayList<Seat>>)seats.subList(34, 41)));
    }
    public final AtomicInteger totalNumberOfPassengers = new AtomicInteger();
    private final ArrayList<ArrayList<Seat>> seats = new ArrayList<ArrayList<Seat>>();
    private final ArrayList<Robot> robots = new ArrayList<Robot>();
}
