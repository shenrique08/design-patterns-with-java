package org.entities;

import lombok.Getter;
import lombok.Setter;
import org.domain.Order;

import java.util.ArrayList;
import java.util.List;

@Getter
class Customer {
    @Setter
    private String name;
    private final List<Order> orders = new ArrayList<>();

    public Customer() {}

    public Customer(String name) {
        this.name = name;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printOwing() {
        printBanner();
        double outstanding = getOutstanding();
        printDetails(outstanding);
    }

    private static void printBanner() {
        System.out.println("*****************************");
        System.out.println("****** Customer totals ******");
        System.out.println("*****************************");
    }

    private double getOutstanding() {
        double result = 0.0;
        for (Order each : orders) {
            result += each.getAmount();
        }
        return result;
    }

    private void printDetails(double outstanding) {
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }
}
