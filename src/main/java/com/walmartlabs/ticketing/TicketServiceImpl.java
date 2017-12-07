package com.walmartlabs.ticketing;

import java.util.ArrayList;

/**
 * Created by LEYED on 12/3/17.
 */
public class TicketServiceImpl implements TicketService {

    SeatsManager seatsManager;
    ArrayList<SeatHold> seatHolds = new ArrayList<>();

    public TicketServiceImpl(SeatsManager seatsManager) {
        this.seatsManager = seatsManager;
    }

    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        SeatHold seatHold = new SeatHold(seatsManager);
        try {
            seatHold.setHoldenSeats(seatsManager.getSeatsFromManager(numSeats));
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        seatHold.setUserEmail(customerEmail);
        seatHold.setSeatHoldId(seatHolds.size() + 1);
        seatHold.setSeatHoldStatus(SeatHold.SeatHoldStatus.HOLDEN);
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
        if(seatHold == null){return "That is an invalid reservation number.";}
        if (seatHold.getSeatHoldStatus().equals(SeatHold.SeatHoldStatus.HOLDEN)){
            seatHold.setHoldTimer(-1);
            seatHold.setSeatHoldStatus(SeatHold.SeatHoldStatus.RESERVED);
            return "Your tickets for " + seatHold.getSeatHoldId() + " are now reserved.";
        }else{
            return "Your reservation has expired or has already been reserved.";
        }
    }

    public int numSeatsAvailable() {
        return seatsManager.getNumberOfSeats();
    }

    public ArrayList<SeatHold> getAllSeatHolds(){
        return seatHolds;
    }
}
