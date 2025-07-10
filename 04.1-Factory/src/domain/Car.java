package domain;

import java.util.Objects;

public class Car implements Vehicle {
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(carName, car.carName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(carName);
    }

    @Override
    public void pickUp(String customerName) {
        System.out.println(this.carName + " is picking up " + customerName);
    }

    @Override
    public void stop() {
        System.out.println(this.carName + " has stopped ");
    }
}
