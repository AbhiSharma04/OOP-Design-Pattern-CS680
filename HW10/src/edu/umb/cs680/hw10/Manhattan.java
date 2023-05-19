package edu.umb.cs680.hw10;

import java.util.List;

public class Manhattan implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double sum = 0;
        int size = p1.size();

        for (int i = 0; i < size; i++) {
            sum += Math.abs(p2.get(i) - p1.get(i));
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Manhattan Class");
    }
}
