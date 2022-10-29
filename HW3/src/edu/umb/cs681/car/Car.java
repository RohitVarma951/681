package edu.umb.cs681.car;

import java.util.*;

public class Car {
    private String make, model;
    private int mileage, year,dominationCount;
    private double price,bore;

    public Car(String make, String model, int year, int mileage, float price, double bore) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.bore = bore;
    }

    public String getMake() { return make; }

    public String getModel() { return model; }

    public int getMileage() { return mileage; }

    public int getYear() { return year; }

    public double getBore() { return bore; }

    public double getPrice() { return price; }

    public void setDominationCount(ArrayList<Car> carsList) {
        for (Car car : carsList) {
            if ((car.getPrice() >= this.getPrice()) && (car.getMileage() >= this.getMileage())
                    && (car.getYear() <= this.getYear())) {
                this.dominationCount++;
            }
        }
    }

    public int getDominationCount() { return dominationCount; }
}
