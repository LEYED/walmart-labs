package com.walmartlabs.ticketing;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by LEYED on 12/3/17.
 */
public class SeatsManagerTS implements SeatsManager {

    PriorityQueue<Seat> seats = new PriorityQueue<>();

    public SeatsManagerTS(ArrayList<Seat> initialSeats) {
        this.seats.addAll(initialSeats);
    }

    public void returnSeatsToManager(ArrayList<Seat> initialSeats){
        this.seats.addAll(initialSeats);
    }

    public int getNumberOfSeats(){
        return this.seats.size();
    }

    public ArrayList<Seat> getSeatsFromManager(int numberOfSeats){//TODO handle this as an exception
        if (getNumberOfSeats() >= numberOfSeats){
            ArrayList<Seat> selectedSeats = new ArrayList<>();
            for (int i = numberOfSeats; i > 0; i--) {
                selectedSeats.add(seats.poll());
            }
            return selectedSeats;
        } else {
            System.out.println("There are no available seats, the current availability is " + getNumberOfSeats());
        }
        return null;
    }

}
