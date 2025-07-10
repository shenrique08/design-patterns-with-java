package org.example;

import org.example.domain.AircraftSingletonEager;

public class Main {
    public static void main(String[] args) {
        bookSeat();
        bookSeat();

    }

    private static void bookSeat() {
        System.out.println(AircraftSingletonEager.getInstance());
        AircraftSingletonEager aircraftSingletonEager = AircraftSingletonEager.getInstance();
        System.out.println(aircraftSingletonEager.bookSeat("1A"));
    }
}