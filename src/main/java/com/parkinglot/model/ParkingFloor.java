package com.parkinglot.model;

import com.parkinglot.model.spot.ParkingSpot;

import java.util.HashMap;

public class ParkingFloor {

    private String name;
    private HashMap<String, ParkingSpot> handicappedSpots;
    private HashMap<String, ParkingSpot> compactSpots;
    private HashMap<String, ParkingSpot> largeSpots;
    private HashMap<String, ParkingSpot> motorbikeSpots;
    private HashMap<String, ParkingSpot> electricSpots;

    private HashMap<String, ParkingSpot> infoPortals;

    private ParkingDisplayBoard displayBoard;

    public ParkingFloor(String name) {
        this.name = name;
    }

    public void addParkingSpot(ParkingSpot spot) {
        switch (spot.getType()) {
            case HANDICAPPED -> handicappedSpots.put(spot.getNumber(), spot);
            case COMPACT -> compactSpots.put(spot.getNumber(), spot);
            case LARGE -> largeSpots.put(spot.getNumber(), spot);
            case MOTORBIKE -> motorbikeSpots.put(spot.getNumber(), spot);
            case ELECTRIC -> electricSpots.put(spot.getNumber(), spot);
            default -> System.out.println("Wrong parking spot type!");
        }
    }

    public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.assignVehicle(vehicle);
        switch (spot.getType()) {
            case HANDICAPPED -> updateDisplayBoardForHandicapped(spot);
            case COMPACT -> updateDisplayBoardForCompact(spot);
            case LARGE -> updateDisplayBoardForLarge(spot);
            case MOTORBIKE -> updateDisplayBoardForMotorbike(spot);
            case ELECTRIC -> updateDisplayBoardForElectric(spot);
            default -> System.out.println("Wrong parking spot type!");
        }
    }

    private void updateDisplayBoardForElectric(ParkingSpot spot) {
    }

    private void updateDisplayBoardForMotorbike(ParkingSpot spot) {
    }

    private void updateDisplayBoardForLarge(ParkingSpot spot) {

    }

    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {

    }

    private void updateDisplayBoardForCompact(ParkingSpot spot) {

    }

    public void freeSpot(ParkingSpot spot) {

    }
}
