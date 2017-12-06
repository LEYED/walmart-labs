package com.walmartlabs.ticketing;

import java.util.ArrayList;

/**
 * Created by LEYED on 12/3/17.
 */
public class SeatHold implements Runnable {

    private ArrayList<Seat> holdenSeats;
    private int holdTimer = 300000;
    private String userEmail;
    private int seatHoldId;
    private SeatHoldStatus seatHoldStatus;
    private SeatsManager seatsManager;

    public SeatHold(SeatsManager seatsManager) {
        this.seatsManager = seatsManager;
    }

    public void run() {
        while (holdTimer >= 0){
            holdTimer --;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(holdTimer == 0){
                returnSeatsToManager();
                this.setSeatHoldStatus(SeatHoldStatus.LOST_SEATS);
            }
        }
    }

    public void returnSeatsToManager(){
        seatsManager.returnSeatsToManager(holdenSeats);
    }

    public ArrayList<Seat> getHoldenSeats() {
        return holdenSeats;
    }

    public void setHoldenSeats(ArrayList<Seat> holdenSeats) {
        this.holdenSeats = holdenSeats;
    }

    public int getHoldTimer() {
        return holdTimer;
    }

    public void setHoldTimer(int holdTimer) {
        this.holdTimer = holdTimer;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getSeatHoldId() {
        return seatHoldId;
    }

    public void setSeatHoldId(int seatHoldId) {
        this.seatHoldId = seatHoldId;
    }

    public SeatHoldStatus getSeatHoldStatus() {
        return seatHoldStatus;
    }

    public void setSeatHoldStatus(SeatHoldStatus seatHoldStatus) {
        this.seatHoldStatus = seatHoldStatus;
    }

    public enum SeatHoldStatus {RESERVED , HOLDED, LOST_SEATS};
}
