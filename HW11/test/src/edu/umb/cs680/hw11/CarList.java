package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    public static List<Car> createcarlist(){
        edu.umb.cs680.hw11.Car verna = new edu.umb.cs680.hw11.Car("Hyundai","Verna", 10,2013,25000);
        edu.umb.cs680.hw11.Car Fortuner = new Car("Toyota","Fortuner",8,2019,45000);
        edu.umb.cs680.hw11.Car audi = new Car("audi","q3",12,2017,50000);
        edu.umb.cs680.hw11.Car swift = new Car("Suzuki","Swift",16,2015,15000);
        edu.umb.cs680.hw11.Car city = new Car("Honda","city",13,2010,20000);

        List<Car> carsList = new ArrayList<>();
        carsList.add(verna);
        carsList.add(Fortuner);
        carsList.add(audi);
        carsList.add(swift);
        carsList.add(city);
        return carsList;
    }
}
