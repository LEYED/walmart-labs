package com.walmartlabs.ticketing;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Created by LEYED on 12/3/17.
 */
public class SeatsManagerImpl implements SeatsManager {

    PriorityQueue<Seat> seats = new PriorityQueue<>();

    public SeatsManagerImpl(ArrayList<Seat> initialSeats) {
        this.seats.addAll(initialSeats);
    }

    public void returnSeatsToManager(ArrayList<Seat> initialSeats){
        this.seats.addAll(initialSeats);
    }

    public int getNumberOfSeats(){
        return this.seats.size();
    }

    public ArrayList<Seat> getSeatsFromManager(int numberOfSeats) throws IndexOutOfBoundsException{
        if (getNumberOfSeats() >= numberOfSeats){
            ArrayList<Seat> selectedSeats = new ArrayList<>();
            for (int i = numberOfSeats; i > 0; i--) {
                selectedSeats.add(seats.poll());
            }
            return selectedSeats;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

}
