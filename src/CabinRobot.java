import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public class CabinRobot extends AbstractRobot implements Callable<AtomicBoolean> {
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

    @Override
    public AtomicBoolean call() throws Exception {

        AtomicBoolean hasElChapo = new AtomicBoolean(false);

        for (ArrayList<Seat> seatsRow : seats)
        {
            for (Seat seat : seatsRow)
            {
                if (seat.isOccupied())
                {
                    try {
                        Thread.sleep(50);
                        Passenger passenger = seat.getPassenger();
                        String passengerFace = Arrays.deepToString(passenger.getFace());
                        //System.out.println(passengerFace);
                        if (passengerFace.contains("elchapo") || passengerFace.contains("sinaloa"))
                        {
                            hasElChapo.set(true);
                        }
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }

                }
            }
        }
        return hasElChapo;
    }

    private final Airbus plane;
    private final ArrayList<ArrayList<Seat>> seats;
}
