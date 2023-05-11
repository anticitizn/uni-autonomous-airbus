package application.plane;

import application.humans.Passenger;

public class Seat {
    private Passenger passenger = null;

    public Seat() {
    }

    public Seat(Passenger passenger) {
        this.passenger = passenger;
    }

    public boolean isOccupied() {
        return passenger != null;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
