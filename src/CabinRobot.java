import java.util.ArrayList;

public class CabinRobot extends AbstractRobot {
    public CabinRobot(Airbus plane, ArrayList<ArrayList<Seat>> seats)
    {
        this.plane = plane;
        this.seats = seats;
    }
    public void countPassengers()
    {
        new Thread( () -> {
            int passengerCount = 0;
            for (ArrayList<Seat> seatsRow : seats)
            {
                for (Seat seat : seatsRow)
                {
                    if (seat.isOccupied())
                    {
                        passengerCount++;
                    }
                }
            }

            plane.totalNumberOfPassengers.addAndGet(passengerCount);
            //System.out.println("Passengers counted: " + passengerCount);
            //System.out.println("Total passengers so far: " + plane.totalNumberOfPassengers.get());
        }).start();

    }

    private final Airbus plane;
    private final ArrayList<ArrayList<Seat>> seats;
}
