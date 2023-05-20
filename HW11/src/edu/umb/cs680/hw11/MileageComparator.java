package edu.umb.cs680.hw11;
import java.util.Comparator;

public class MileageComparator implements Comparator<Car>{

    @Override
    public int compare(Car c1, Car c2) {
        return (int) (c1.GetMileage()-c2.GetMileage());
    }
}
