package com.parkinglot.model.spot;

import com.parkinglot.constant.ParkingSpotType;
import com.parkinglot.model.Vehicle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ParkingSpot {

    private final ParkingSpotType type;

    private String number;
    private boolean free;
    private Vehicle vehicle;


    public ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        free = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        free = true;
    }

    public boolean isFree() {
        return true;
    }
}
