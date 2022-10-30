package edu.umb.cs681.car;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {

        ArrayList<Car> carsList = new ArrayList<>();

        Car car1 = new Car("Lexus","LC 500", 2022, 19, 93150,3.7);
        Car car2 = new Car("Nissan", "GT-R", 2021, 19, 113540,3.8);
        Car car3 = new Car("Chevrolet", "Corvette", 2023, 20, 64500,4.1);
        Car car4 = new Car("Dodge","Charger", 2023, 24, 32645,4.0);
        Car car5 = new Car("Toyota","Corolla", 2023, 35, 20425,3.2);

        carsList.add(car1);
        carsList.add(car2);
        carsList.add(car3);
        carsList.add(car4);
        carsList.add(car5);

        System.out.println("Lowest Car Price: "+carsList.stream().min(Comparator.comparing(Car::getPrice)).get().getPrice());
        System.out.println("Highest Car Price: "+carsList.stream().max(Comparator.comparing(Car::getPrice)).get().getPrice());
        System.out.println("Average Car Price: "+carsList.stream().map(Car::getPrice).reduce(new int[2], (result, price) ->{
            double average = Math.round((result[0] * result[1] + price)/(result[0]+1));
            result[0]++;
            result[1] = (int) average;
            return result;},(finalResult, intermediateResult) -> finalResult)[1]);
    }
}