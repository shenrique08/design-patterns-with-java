package org.refact.domain;

import lombok.Getter;

@Getter
public abstract class Party {
    protected final String name;

    public Party(String name) {
        this.name = name;
    }

    public abstract Double getAnnualCost();
}
