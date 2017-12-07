package com.walmartlabs.ticketing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by LEYED on 12/4/17.
 */
public class SeatsManagerImplTest {

    ArrayList<Seat> startingSeats = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        startingSeats.add(new Seat("A1", 1));
        startingSeats.add(new Seat("A2", 2));
        startingSeats.add(new Seat("A3", 3));
        startingSeats.add(new Seat("A4", 4));
        startingSeats.add(new Seat("A5", 5));
        startingSeats.add(new Seat("A6", 6));
        startingSeats.add(new Seat("A7", 7));
        startingSeats.add(new Seat("A8", 8));
        startingSeats.add(new Seat("A9", 9));
        startingSeats.add(new Seat("A10", 10));
    }

    @Test
    public void returnSeatsToManager() throws Exception {
        SeatsManager seatsManager = new SeatsManagerImpl(startingSeats);
        ArrayList<Seat> returnedSeats = seatsManager.getSeatsFromManager(5);
        seatsManager.returnSeatsToManager(returnedSeats);
        assertEquals(seatsManager.getNumberOfSeats(), 10);
    }

    @Test
    public void getNumberOfSeats() throws Exception {
        SeatsManager seatsManager = new SeatsManagerImpl(startingSeats);
        System.out.println("Testing");
        assertEquals(10, seatsManager.getNumberOfSeats());
    }

    @Test
    public void getSeatsFromManager() throws Exception {
        SeatsManager seatsManager = new SeatsManagerImpl(startingSeats);
        ArrayList<Seat> returnedSeats = seatsManager.getSeatsFromManager(5);
        assertEquals(returnedSeats.get(0).getSeatId(), "A10");
        assertEquals(returnedSeats.get(1).getSeatId(), "A9");
        assertEquals(returnedSeats.get(2).getSeatId(), "A8");
        assertEquals(returnedSeats.get(3).getSeatId(), "A7");
        assertEquals(returnedSeats.get(4).getSeatId(), "A6");
    }

}