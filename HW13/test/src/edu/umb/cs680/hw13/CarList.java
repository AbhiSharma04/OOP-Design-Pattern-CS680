package edu.umb.cs680.hw13;

import java.util.ArrayList;
import java.util.List;

public class CarList {
    public static List<Car> createcarlist(){
        edu.umb.cs680.hw13.Car verna = new edu.umb.cs680.hw13.Car("Hyundai","Verna", 10,2013,25000);
        edu.umb.cs680.hw13.Car Fortuner = new edu.umb.cs680.hw13.Car("Toyota","Fortuner",8,2019,45000);
        edu.umb.cs680.hw13.Car audi = new edu.umb.cs680.hw13.Car("audi","q3",12,2017,50000);
        edu.umb.cs680.hw13.Car swift = new edu.umb.cs680.hw13.Car("Suzuki","Swift",16,2015,15000);
        edu.umb.cs680.hw13.Car city = new edu.umb.cs680.hw13.Car("Honda","city",13,2010,20000);

        List<Car> carsList = new ArrayList<>();
        carsList.add(verna);
        carsList.add(Fortuner);
        carsList.add(audi);
        carsList.add(swift);
        carsList.add(city);
        return carsList;
    }
}
