package edu.umb.cs680.hw11;

import java.util.Comparator;

public class PriceComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {

        return (int) (c1.GetPrice()-c2.GetPrice());

    }
}
