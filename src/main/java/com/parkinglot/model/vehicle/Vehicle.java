package com.parkinglot.model.vehicle;

import com.parkinglot.constant.VehicleType;
import com.parkinglot.model.ParkingTicket;

public abstract class Vehicle {
    private final VehicleType type;
    private String licenseNumber;
    private ParkingTicket ticket;

    public Vehicle(VehicleType type) {
        this.type = type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}
