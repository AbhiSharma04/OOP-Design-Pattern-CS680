package edu.umb.cs680.hw11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarComparatorsTest {

    static List<Car> carsListPrice ;
    @BeforeAll
    public static void setupcarlist(){
        CarList carsList= new CarList();
        carsListPrice=carsList.createcarlist();

    }


    @Test
    public void CheckPriceComparator(){
        Collections.sort(carsListPrice,new PriceComparator());
        List<String> sortedcar = new ArrayList<>();
        for(Car car: carsListPrice){
            sortedcar.add(car.GetModel());
        }
        System.out.println(sortedcar);
        String expected= "[Swift, city, Verna, Fortuner, q3]";
        assertEquals(expected,sortedcar.toString());


    }
    @Test
    public void CheckMileageComparator(){
        Collections.sort(carsListPrice,new MileageComparator());
        List<String> sortedcar = new ArrayList<>();
        for(Car car: carsListPrice){
            sortedcar.add(car.GetModel());
        }
        String expected= "[Fortuner, Verna, q3, city, Swift]";
        assertTrue(sortedcar.toString().equals(expected));
        System.out.println(sortedcar);


    }

    @Test
    public void CheckYearComparator(){
        Collections.sort(carsListPrice,new YearComparator());
        List<String> sortedcar = new ArrayList<>();
        for(Car car: carsListPrice){
            sortedcar.add(car.GetModel());
        }
        String expected="[city, Verna, Swift, q3, Fortuner]";
        //System.out.println(sortedcar);
        assertEquals(expected,sortedcar.toString());

    }

    @Test
    public void CheckParetoComparator(){
        for(Car car:carsListPrice){
            car.setDominationCount(carsListPrice);
        }
        Collections.sort(carsListPrice,new ParetoComparator());
        List<String> sortedcar = new ArrayList<>();
        for(Car car: carsListPrice){
            sortedcar.add(car.GetModel());
        }
        String expected ="[Verna, Fortuner, q3, city, Swift]";
        assertEquals(expected,sortedcar.toString());
        //System.out.println(sortedcar);

    }

}
