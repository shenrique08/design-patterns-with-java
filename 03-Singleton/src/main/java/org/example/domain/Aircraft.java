package org.example.domain;

import java.util.HashSet;
import java.util.Set;

public final class Aircraft {

    private final Set<String> availableSeats = new HashSet<>();
    private final String name;
    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public Aircraft(String name) {
        this.name = name;
    }

    public boolean bookSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
