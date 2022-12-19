package edu.umb.cs681.hw11;

import java.util.ArrayList;
import java.util.List;

public final class Position {
    private final double latitude, longitude, altitude;

    public Position(double latitude, double longitude, double altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public double getLatitude(){
        return this.latitude;
    }

    public double getLongitude(){
        return this.longitude;
    }

    public double getAltitude(){
        return this.altitude;
    }

    public List<Double> coordinate(){
        List<Double> coordinatesList = new ArrayList<>();
        coordinatesList.add(this.latitude);
        coordinatesList.add(this.longitude);
        coordinatesList.add(this.altitude);
        return coordinatesList;
    }

    public Position change(double newLatitude,double newLongitude,double newAltitude){
        return new Position(newLatitude, newLongitude, newAltitude);
    }

    public double distanceTo(Position anotherPosition){
        //manhattan distance
        double distance = 0;
        distance = distance + Math.abs(this.latitude - anotherPosition.latitude);
        distance = distance + Math.abs(this.longitude - anotherPosition.longitude);
        distance = distance + Math.abs(this.altitude - anotherPosition.altitude);
        return distance;
    }
}
