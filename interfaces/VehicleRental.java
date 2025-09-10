package interfaces;

public interface VehicleRental {
    void rent(String customerId);
    void returnVehicle(String rentId);
}

class Car implements VehicleRental {
    @Override
    public void rent(String customerId) {
        System.out.println("Car rented to customer: " + customerId);
    }

    @Override
    public void returnVehicle(String rentId) {
        System.out.println("Car returned for rent ID: " + rentId);
    }
}

class Bike implements VehicleRental {
    @Override
    public void rent(String customerId) {
        System.out.println("Bike rented to customer: " + customerId);
    }

    @Override
    public void returnVehicle(String rentId) {
        System.out.println("Bike returned for rent ID: " + rentId);
    }
}