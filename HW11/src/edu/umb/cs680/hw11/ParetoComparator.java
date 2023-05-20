package edu.umb.cs680.hw11;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {

        return c1.getDominationCount()-c2.getDominationCount();
    }
}
