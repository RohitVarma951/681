package edu.umb.cs681.distance;

import java.util.*;

public class Distance {
//    public static double get(List<Double> p1, List<Double> p2) {
//        return Distance.get((List<Double> p, List<Double> p0)->{
//            double sumOfMod = 0;
//            for(int i=0; i < p.size(); i++) {
//                sumOfMod += Math.abs( p.get(i)-p0.get(i) );
//            }
//            return sumOfMod;
//        });
//    }

    public static double get(List<Double> p1, List<Double> p2, DistanceMetric metric) {
        double sum=0;
//        sum+=p1.size()->{Math.pow(p1.get(i)-p2.get(i),2);};
        return sum;
    }

    public static List<List<Double>> matrix(List<List<Double>> points) {
        return Distance.matrix(points,(List<Double> p, List<Double> p0)->{
            double sumOfMod = 0;
            for(int i=0; i < p.size(); i++) {
                sumOfMod += Math.abs( p.get(i)-p0.get(i) );
            }
            return sumOfMod;
        });//replace euclidean
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
        ;
    }

}