package edu.umb.cs680.hw11;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return c1.GetYear()-c2.GetYear();
    }
}
