package com.walmartlabs.ticketing;

import java.util.ArrayList;

/**
 * Created by LEYED on 12/4/17.
 */
public interface PersistentSeatsService {
    ArrayList<Seat> getSeatsOnDataBase();
}
