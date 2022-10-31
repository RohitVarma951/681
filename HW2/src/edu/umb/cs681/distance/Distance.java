package edu.umb.cs681.distance;

import java.util.*;

public class Distance {
    public static double get(List<Double> p1, List<Double> p2) {
        return Distance.get(p1,p2,(List<Double> p, List<Double> p0)->{
            double sumOfMod = 0;
            for(int i=0; i < p.size(); i++) {
                sumOfMod += Math.abs( p.get(i)-p0.get(i) );
            }
            return sumOfMod;
        });
    }

    public static double get(List<Double> p1, List<Double> p2, DistanceMetric metric) {
        return metric.distance(p1,p2);
    }

    public static List<List<Double>> matrix(List<List<Double>> points) {
        return Distance.matrix(points, new Euclidean());
    };

    public static List<List<Double>> matrix(List<List<Double>> points, DistanceMetric metric) {
        int numOfPoints = points.size();
        List<List<Double>> distanceMatrix = Distance.initDistanceMatrix(numOfPoints);
        List<Double> current, peer;

        for(int i=0; i < numOfPoints; i++) {
            current = points.get(i);
            for(int j=0; j < numOfPoints; j++) {
                peer = points.get(j);
                double distance = Distance.get(current, peer, metric);
                distanceMatrix.get(i).set(j, distance);
            }
        }
        return distanceMatrix;
    }

    private static List<List<Double>> initDistanceMatrix(int numOfPoints){
        List<List<Double>> distanceMatrix = new ArrayList<>(numOfPoints);
        for(int i=0; i < numOfPoints; i++) {
            Double[] vector = new Double[numOfPoints];
            Arrays.fill(vector, 0.0);
            distanceMatrix.add( Arrays.asList(vector) );
        }
        return distanceMatrix;
    }

    public static void main(String args[]){
        List<Double> p1, p2, p3, p4, p5;
        List<List<Double>> pointsList = new LinkedList<>();
        p1 = Arrays.asList(2.0, 3.0, 5.0);
        p2 = Arrays.asList(2.0, 5.0, 6.0);
        p3 = Arrays.asList(3.0, 4.0, 8.0);
        p4 = Arrays.asList(4.0, 2.0, 1.0);
        p5 = Arrays.asList(5.0, 5.0, 6.0);
        pointsList.add(p1);
        pointsList.add(p2);
        pointsList.add(p3);
        pointsList.add(p4);
        pointsList.add(p5);
        System.out.println(Distance.get(p1,p2));
        System.out.println(Distance.get(p4,p5));
        System.out.println(Distance.matrix(pointsList));
    }

}