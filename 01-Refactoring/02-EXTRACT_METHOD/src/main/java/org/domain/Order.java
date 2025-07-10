package org.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Double amount;

    public Order(Double amount) {
        this.amount = amount;
    }
}