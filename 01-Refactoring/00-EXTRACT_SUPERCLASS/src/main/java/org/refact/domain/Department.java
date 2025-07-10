package org.refact.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Department extends Party {
    private final List<Party> staff = new ArrayList<>();

    public Department(String name) {
        super(name);
    }

    @Override
    public Double getAnnualCost() {
        Double result = 0.0;
        for (Party each : staff) {
            result += each.getAnnualCost();
        }
        return result;
    }

    public void addStaff(Party arg) {
        staff.add(arg);
    }
}