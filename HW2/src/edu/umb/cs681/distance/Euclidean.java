package edu.umb.cs681.distance;

import java.util.*;

public class Euclidean implements DistanceMetric {
    public double distance(List<Double> p1, List<Double> p2) {
        double sumOfSquared = 0;
        for(int i=0; i < p1.size(); i++) {
            sumOfSquared += Math.pow( p1.get(i)-p2.get(i), 2 );
        }
        return Math.sqrt(sumOfSquared);
    }
}

