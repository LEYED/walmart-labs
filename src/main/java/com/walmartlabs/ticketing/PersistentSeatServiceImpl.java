package com.walmartlabs.ticketing;

import java.util.ArrayList;

/**
 * Created by LEYED on 12/4/17.
 */
public class PersistentSeatServiceImpl implements PersistentSeatsService {
    @Override
    public ArrayList<Seat> getSeatsOnDataBase() {
        ArrayList<Seat> startingSeats = new ArrayList<>();
        startingSeats.add(new Seat("A1", 10));
        startingSeats.add(new Seat("A2", 10));
        startingSeats.add(new Seat("A3", 10));
        startingSeats.add(new Seat("A4", 10));
        startingSeats.add(new Seat("A5", 10));
        startingSeats.add(new Seat("A6", 10));
        startingSeats.add(new Seat("A7", 10));
        startingSeats.add(new Seat("A8", 10));
        startingSeats.add(new Seat("A9", 10));
        startingSeats.add(new Seat("B1", 20));
        startingSeats.add(new Seat("B2", 20));
        startingSeats.add(new Seat("B3", 20));
        startingSeats.add(new Seat("B4", 20));
        startingSeats.add(new Seat("B5", 20));
        startingSeats.add(new Seat("B6", 20));
        startingSeats.add(new Seat("B7", 20));
        startingSeats.add(new Seat("B8", 30));
        startingSeats.add(new Seat("B9", 30));
        startingSeats.add(new Seat("C1", 30));
        startingSeats.add(new Seat("C2", 30));
        startingSeats.add(new Seat("C3", 30));
        startingSeats.add(new Seat("C4", 30));
        startingSeats.add(new Seat("C5", 30));
        startingSeats.add(new Seat("C6", 30));
        startingSeats.add(new Seat("C7", 30));
        startingSeats.add(new Seat("C8", 30));
        startingSeats.add(new Seat("C9", 30));
        startingSeats.add(new Seat("D1", 40));
        startingSeats.add(new Seat("D2", 40));
        startingSeats.add(new Seat("D3", 40));
        startingSeats.add(new Seat("D4", 40));
        startingSeats.add(new Seat("D5", 40));
        startingSeats.add(new Seat("D6", 40));
        startingSeats.add(new Seat("D7", 40));
        startingSeats.add(new Seat("D8", 40));
        startingSeats.add(new Seat("D9", 40));
        return startingSeats;
    }
}
