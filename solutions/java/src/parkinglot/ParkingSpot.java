package parkinglot;

import parkinglot.vehicletype.Vehicle;
import parkinglot.vehicletype.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    // To identify a unique spot
    private final VehicleType vehicleType;
    // To identify the type of vehicle that can be parked in this spot
    private Vehicle parkedVehicle;
    // Which vehicle has been parked currently in this spot

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getType() == vehicleType) {
            parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Invalid vehicle type or spot already occupied.");
        }
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }
}
