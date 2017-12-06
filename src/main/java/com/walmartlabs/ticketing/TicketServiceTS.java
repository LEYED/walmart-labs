package com.walmartlabs.ticketing;

import java.util.ArrayList;

/**
 * Created by LEYED on 12/3/17.
 */
public class TicketServiceTS implements TicketService {

    SeatsManager seatsManager;
    ArrayList<SeatHold> seatHolds = new ArrayList<>();
    PersistentSeatsService persistentSeatsService = new PersistentSeatServiceImpl();

    public TicketServiceTS() {
        seatsManager = new SeatsManagerTS(persistentSeatsService.getSeatsOnDataBase());
    }

    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        SeatHold seatHold = new SeatHold(seatsManager);
        seatHold.setHoldenSeats(seatsManager.getSeatsFromManager(numSeats));
        seatHold.setUserEmail(customerEmail);
        seatHold.setSeatHoldId(seatHolds.size() + 1);
        seatHold.setSeatHoldStatus(SeatHold.SeatHoldStatus.HOLDED);
        seatHolds.add(seatHold);
        new Thread(seatHold).start();
        return seatHold;
    }

    public String reserveSeats(int seatHoldId, String customerEmail) {
        SeatHold seatHold = seatHolds.stream()
                .filter(x -> x.getSeatHoldId() == seatHoldId)
                .findFirst().orElse(null);
        return getReservationMessage(seatHold);
    }

    private String getReservationMessage(SeatHold seatHold) {
        if (!seatHold.getSeatHoldStatus().equals(SeatHold.SeatHoldStatus.LOST_SEATS)){
            seatHold.setHoldTimer(-1);
            seatHold.setSeatHoldStatus(SeatHold.SeatHoldStatus.RESERVED);
            return "Your tickets for " + seatHold.getSeatHoldId() + " are now reserved.";
        }else{
            return "Your reservation has expired, your seats can be claimed by anyone!";
        }
    }

    public int numSeatsAvailable() {
        return seatsManager.getNumberOfSeats();
    }

    public ArrayList<SeatHold> getAllSeatHolds(){
        return seatHolds;
    }
}
