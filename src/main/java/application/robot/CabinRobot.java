package application.robot;

import application.utils.Logger;
import application.humans.Passenger;
import application.plane.Airbus;
import application.plane.Seat;

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
            Logger.log("Cabin robot counted " + passengerCount + " passengers in his assigned rows");
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
