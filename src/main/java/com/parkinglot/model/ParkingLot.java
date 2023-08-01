package com.parkinglot.model;

import com.parkinglot.constant.VehicleType;

import javax.xml.stream.Location;
import java.util.HashMap;


public class ParkingLot {

    private static ParkingLot parkingLot = null;
    private final int maxCompactCount;
    private final int maxLargeCount;
    private final int maxMotorbikeCount;
    private final int maxElectricCount;
    private String name;
    private Location address;
    private ParkingRate parkingRate;
    private int compactSpotCount;
    private int largeSpotCount;
    private int motorbikeSpotCount;
    private int electricSpotCount;
    private HashMap<String, EntrancePanel> entrancePanels;
    private HashMap<String, ExitPanel> exitPanels;
    private HashMap<String, ParkingFloor> parkingFloors;
    private HashMap<String, ParkingTicket> activeTickets;

    private ParkingLot(int maxCompactCount, int maxLargeCount, int maxMotorbikeCount, int maxElectricCount) {
        this.maxCompactCount = maxCompactCount;
        this.maxLargeCount = maxLargeCount;

        this.maxMotorbikeCount = maxMotorbikeCount;
        this.maxElectricCount = maxElectricCount;
    }

    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(12, 12, 12, 12);
        }
        return parkingLot;
    }

    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) {
        return null;
    }

    public boolean isFull(VehicleType type) {
        // trucks and vans can only be parked in LargeSpot
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            return largeSpotCount >= maxLargeCount;
        }

        // motorbikes can only be parked at motorbike spots
        if (type == VehicleType.MOTORBIKE) {
            return motorbikeSpotCount >= maxMotorbikeCount;
        }

        // cars can be parked at compact or large spots
        if (type == VehicleType.CAR) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }

        // electric car can be parked at compact, large or electric spots
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
                + maxElectricCount);
    }

    // increment the parking spot count based on the vehicle type
    private boolean incrementSpotCount(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            largeSpotCount++;
        } else if (type == VehicleType.MOTORBIKE) {
            motorbikeSpotCount++;
        } else if (type == VehicleType.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else { // electric car
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
        return true;
    }

    public boolean isFull() {

        return true;
    }

    public void addParkingFloor(ParkingFloor floor) {
        /* store in database */
    }

    public void addEntrancePanel(EntrancePanel entrancePanel) {
        /* store in database */
    }

    public void addExitPanel(ExitPanel exitPanel) {
        /* store in database */
    }
}
