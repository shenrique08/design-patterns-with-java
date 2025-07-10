package org.refact.domain;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee extends Party {
    private final Long id;
    private Double annualCost;

    public Employee(String name, Long id, Double annualCost) {
        super(name);
        this.id = id;
        this.annualCost = annualCost;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Double getAnnualCost() {
        return annualCost;
    }
}