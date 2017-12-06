package com.walmartlabs.ticketing;

/**
 * Created by LEYED on 12/3/17.
 */
public class Seat implements Comparable{

    private String seatId;
    private int seatValue;

    public Seat(String seatId, int seatValue) {
        this.seatId = seatId;
        this.seatValue = seatValue;
    }

    public String getSeatId() {
        return seatId;
    }

    public int getSeatValue() {
        return seatValue;
    }

    public int compareTo(Object o) {
        Seat seat = (Seat) o;
        return seat.seatValue - this.seatValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (seatValue != seat.seatValue) return false;
        return seatId != null ? seatId.equals(seat.seatId) : seat.seatId == null;
    }

    @Override
    public int hashCode() {
        int result = seatId != null ? seatId.hashCode() : 0;
        result = 31 * result + seatValue;
        return result;
    }
}
