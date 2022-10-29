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
//        Car car6 = new Car("Toyota","Corolla", 2023, 35, 20425,3.2);

        carsList.add(car1);
        carsList.add(car2);
        carsList.add(car3);
        carsList.add(car4);
        carsList.add(car5);
//        carsList.add(car6);

        carsList.forEach((Car car)->car.setDominationCount(carsList));

        System.out.println("Cars order before sorting:");
        carsList.forEach((Car car)->System.out.println(car.getMake()+" "+car.getModel()+" "+car.getYear()+" "+car.getPrice()));

        System.out.println("\nCars list after sorting according to price:");
        List<Car> carsByPrice = carsList.stream().sorted(Comparator.comparing((Car car)->car.getPrice())).collect(Collectors.toList());
        carsByPrice.forEach((Car car)->System.out.println(car.getMake()+" "+car.getModel()+" "+car.getPrice()));

        System.out.println("\nCars list after sorting according to Mileage:");
        List<Car> carsByMileage = carsList.stream().sorted(Comparator.comparing((Car car)->car.getMileage())).collect(Collectors.toList());
        carsByMileage.forEach((Car car)->System.out.println(car.getMake()+" "+car.getModel()+" "+car.getMileage()));

        System.out.println("\nCars list after sorting according to Year:");
        List<Car> carsByYear = carsList.stream().sorted(Comparator.comparing((Car car)->car.getYear())).collect(Collectors.toList());
        carsByYear.forEach((Car car)->System.out.println(car.getMake()+" "+car.getModel()+" "+car.getYear()));

        System.out.println("\nCars list after sorting according to Domination Count:");
        List<Car> carsByDominationCount = carsList.stream().sorted(Comparator.comparing((Car car)->car.getDominationCount())).collect(Collectors.toList());
        carsByDominationCount.forEach((Car car)->System.out.println(car.getMake()+" "+car.getModel()+" "+car.getDominationCount()));

        System.out.println("\nCars list after sorting according to Bore Radius:");
        List<Car> carsByBore = carsList.stream().sorted(Comparator.comparing((Car car)->car.getBore())).collect(Collectors.toList());
        carsByBore.forEach((Car car)->System.out.println(car.getMake()+" "+car.getModel()+" "+car.getBore()));

        int size=carsList.size();
        if(size%2==0){
            System.out.println("\nMedian Price: " + (carsByPrice.get((size+1)/2).getPrice()+ carsByPrice.get((size-1)/2).getPrice())/2);
            System.out.println("Median Mileage: " + (carsByMileage.get((size+1)/2).getMileage()+carsByMileage.get((size-1)/2).getMileage())/2);
            System.out.println("Median Year: " + (carsByYear.get((size+1)/2).getYear()+carsByYear.get((size-1)/2).getYear())/2);
            System.out.println("Median Domination Count: " + (carsByDominationCount.get((size+1)/2).getDominationCount()+carsByDominationCount.get((size-1)/2).getDominationCount())/2);
            System.out.println("Median Bore Radius: " + (carsByBore.get((size+1)/2).getBore()+carsByBore.get((size-1)/2).getBore())/2);
        }
        else {
            System.out.println("\nMedian Price: " + carsByPrice.get((size+1)/2).getPrice());
            System.out.println("Median Mileage: " + carsByMileage.get((size+1)/2).getMileage());
            System.out.println("Median Year: " + carsByYear.get((size+1)/2).getYear());
            System.out.println("Median Domination Count: " + carsByDominationCount.get((size+1)/2).getDominationCount());
            System.out.println("Median Bore Radius: " + carsByBore.get((size+1)/2).getBore());
        }
    }
}