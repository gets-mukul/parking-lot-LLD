package com.parkinglot.model;

import com.parkinglot.model.spot.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingDisplayBoard {

    private String id;
    private HandicappedSpot handicappedFreeSpot;
    private CompactSpot compactFreeSpot;
    private LargeSpot largeFreeSpot;
    private MotorbikeSpot motorbikeFreeSpot;
    private ElectricSpot electricFreeSpot;

    public void showEmptySpotNumber() {
        String message = "";
        if (handicappedFreeSpot.isFree()) {
            message += "Free Handicapped: " + handicappedFreeSpot.getNumber();
        } else {
            message += "Handicapped is full";
        }
        message += System.lineSeparator();

        if (compactFreeSpot.isFree()) {
            message += "Free Compact: " + compactFreeSpot.getNumber();
        } else {
            message += "Compact is full";
        }
        message += System.lineSeparator();

        if (largeFreeSpot.isFree()) {
            message += "Free Large: " + largeFreeSpot.getNumber();
        } else {
            message += "Large is full";
        }
        message += System.lineSeparator();

        if (motorbikeFreeSpot.isFree()) {
            message += "Free Motorbike: " + motorbikeFreeSpot.getNumber();
        } else {
            message += "Motorbike is full";
        }
        message += System.lineSeparator();

        if (electricFreeSpot.isFree()) {
            message += "Free Electric: " + electricFreeSpot.getNumber();
        } else {
            message += "Electric is full";
        }

    }
}
