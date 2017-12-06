package com.walmartlabs.ticketing;

import java.util.ArrayList;

/**
 * Created by LEYED on 12/3/17.
 */
public interface SeatsManager {
    void returnSeatsToManager(ArrayList<Seat> initialSeats);
    ArrayList<Seat> getSeatsFromManager(int numberOfSeats);
    int getNumberOfSeats();
}
