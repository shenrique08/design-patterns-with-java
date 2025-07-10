package domain;

import java.util.Objects;

public class Bicycle implements Vehicle {
    private String bicycleName;

    public Bicycle(String bicycleName) {
        this.bicycleName = bicycleName;
    }

    public String getBicycleName() {
        return bicycleName;
    }

    public void setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return Objects.equals(bicycleName, bicycle.bicycleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(bicycleName);
    }

    @Override
    public void pickUp(String customerName) {
        System.out.println(this.bicycleName + " is picking up " + customerName);
    }

    @Override
    public void stop() {
        System.out.println(this.bicycleName + " has stopped ");
    }
}
