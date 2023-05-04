package edu.umb.cs680.hw13;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Collections.sort(carsListPrice, Comparator.comparing((Car car)-> car.GetPrice()));
        List<String> sortedcar = new ArrayList<>();
        for(Car car: carsListPrice){
            sortedcar.add(car.GetModel());
        }
        String expectedPriceList= "[Swift, city, Verna, Fortuner, q3]";
        assertEquals(expectedPriceList,sortedcar.toString());


    }
    @Test
    public void CheckMileageComparator(){
        Collections.sort(carsListPrice,Comparator.comparing((Car car)->car.GetMileage()));
        List<String> sortedcar = new ArrayList<>();
        for(Car car: carsListPrice){
            sortedcar.add(car.GetModel());
        }
        String expectedMileageList= "[Fortuner, Verna, q3, city, Swift]";
        assertTrue(sortedcar.toString().equals(expectedMileageList));


    }

    @Test
    public void CheckYearComparator(){
        Collections.sort(carsListPrice,Comparator.comparing((Car car)->car.GetYear()));
        List<String> sortedcar = new ArrayList<>();
        for(Car car: carsListPrice){
            sortedcar.add(car.GetModel());
        }
        String expected="[city, Verna, Swift, q3, Fortuner]";
        assertEquals(expected,sortedcar.toString());

    }



    @Test
    public void CheckParetoComparator(){
        for(Car car:carsListPrice){
            car.setDominationCount(carsListPrice);
        }
        Collections.sort(carsListPrice,Comparator.comparing((Car car)-> car.getDominationCount()));
        List<String> sortedcar = new ArrayList<>();
        for(Car car: carsListPrice){
            sortedcar.add(car.GetModel());
        }
        String expectedParetoList ="[Fortuner, Verna, q3, city, Swift]";
        assertEquals(expectedParetoList,sortedcar.toString());

    }

}
