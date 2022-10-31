package edu.umb.cs681.distance;

import java.util.*;

public class Manhattan implements DistanceMetric {
    public double distance(List<Double> p1, List<Double> p2) {
        double sumOfMod = 0;
        for(int i=0; i < p1.size(); i++) {
            sumOfMod += Math.abs( p1.get(i)-p2.get(i) );
        }
        return sumOfMod;
    }
}
