package com.walmartlabs.ticketing;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by LEYED on 12/4/17.
 */
public class TicketServiceImplTest {

    TicketService ticketService;
    PersistentSeatsService persistentSeatsService = new PersistentSeatServiceImpl();
    SeatsManager seatsManager = new SeatsManagerImpl(persistentSeatsService.getSeatsOnDataBase());

    @Test
    public void numSeatsAvailable() throws Exception {
        ticketService =  new TicketServiceImpl(seatsManager);
        int numberOfSeats = ticketService.numSeatsAvailable();
        assertEquals(numberOfSeats, 36);
    }

    @Test
    public void findAndHoldSeats() throws Exception {
        ticketService =  new TicketServiceImpl(seatsManager);
        int numberOfSeats = ticketService.numSeatsAvailable();
        assertEquals(numberOfSeats, 36);
        ticketService.findAndHoldSeats(2, "user@email.com");
        numberOfSeats = ticketService.numSeatsAvailable();
        assertEquals(numberOfSeats, 34);
        assertEquals(ticketService.getAllSeatHolds().get(0).getSeatHoldId(), 1);
        assertEquals(ticketService.getAllSeatHolds().get(0).getSeatHoldStatus(), SeatHold.SeatHoldStatus.HOLDEN);
        assertEquals(ticketService.getAllSeatHolds().get(0).getUserEmail(), "user@email.com");
        assertEquals(ticketService.getAllSeatHolds().get(0).getHoldenSeats().get(0).getSeatValue(), 40);
        assertEquals(ticketService.getAllSeatHolds().get(0).getHoldenSeats().get(1).getSeatValue(), 40);
        Thread.sleep(2000);
        assertNotEquals(ticketService.getAllSeatHolds().get(0).getHoldTimer(), 300000);
    }

    @Test
    public void reserveSeats() throws Exception {
        ticketService =  new TicketServiceImpl(seatsManager);
        ticketService.findAndHoldSeats(2, "user@email.com");
        assertEquals(ticketService.getAllSeatHolds().get(0).getSeatHoldStatus(), SeatHold.SeatHoldStatus.HOLDEN);
        ticketService.reserveSeats(1, "user@email.com");
        assertEquals(ticketService.getAllSeatHolds().get(0).getSeatHoldStatus(), SeatHold.SeatHoldStatus.RESERVED);
        assertEquals(ticketService.getAllSeatHolds().get(0).getHoldTimer(), -1);
        assertEquals(ticketService.getAllSeatHolds().get(0).getHoldenSeats().get(0).getSeatValue(), 40);
        assertEquals(ticketService.getAllSeatHolds().get(0).getHoldenSeats().get(1).getSeatValue(), 40);
    }

}