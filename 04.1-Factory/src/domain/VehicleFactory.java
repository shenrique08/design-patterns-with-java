package domain;

public abstract class VehicleFactory {

    abstract Vehicle getVehicle(String vehicleName);

    Vehicle pickUp(String customerName, String vehicleName) {
        Vehicle car = this.getVehicle(vehicleName);
        car.pickUp(customerName);
        return car;
    }

}
