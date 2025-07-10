package org.example.domain;

import java.util.HashSet;
import java.util.Set;

public class AircraftSingletonLazy {
    private static final AircraftSingletonLazy INSTANCE = new AircraftSingletonLazy("787-900");
    private final Set<String> availableSeats = new HashSet<>();

    private AircraftSingletonLazy(String name) {
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }


    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }

    public static AircraftSingletonLazy getInstance() {
        return INSTANCE;
    }

}
