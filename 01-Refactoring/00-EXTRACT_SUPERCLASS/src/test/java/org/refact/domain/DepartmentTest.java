package org.refact.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void testTotalAnnualCost() {
        Employee john = new Employee("John Doe", 1L, 50000.0);
        Employee jane = new Employee("Jane Smith", 2L, 60000.0);
        Department engineering = new Department("Engineering");

        engineering.addStaff(john);
        engineering.addStaff(jane);

        Double expectedCost = 110000.0;
        assertEquals(expectedCost, engineering.getAnnualCost(), "O custo anual do departamento deve ser a soma dos custos dos funcionários.");
    }
}