package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.List;

public class MinMaxNormalization {

    public static List<List<Double>> NormalizeCarsMinMax (Car... cars) {
        List<List<Double>> CarData = new ArrayList<>();


        double minYear = Double.MAX_VALUE;
        double maxYear = Double.MIN_VALUE;
        double minPrice = Double.MAX_VALUE;
        double maxPrice = Double.MIN_VALUE;
        double minMil = Double.MAX_VALUE;
        double maxMil = Double.MIN_VALUE;


       // We have used this for loop to find min and max values of these parameters
        for (Car car : cars) {

            double year = car.GetYear();
            double price = car.GetPrice();
            double Mil = car.GetMileage();

            minYear = Math.min(minYear, year);
            maxYear = Math.max(maxYear, year);
            minPrice = Math.min(minPrice, price);
            maxPrice = Math.max(maxPrice, price);
            minMil = Math.min(minMil, Mil);
            maxMil = Math.max(maxMil, Mil);
        }

        // After getting the min and max values we  are performing normalizing using formula given below
        // then adding each set of values to list and adding that list to the main list that consisit all normalized values of car objects .
        for (Car car : cars) {
            List<Double> CarValuesNormalized= List.of (((car.GetMileage () - minMil) / (maxMil - minMil)),((car.GetPrice () - minPrice) / (maxPrice - minPrice)),((car.GetYear () - minYear) / (maxYear - minYear)));
            CarData.add(CarValuesNormalized);
        }

        return CarData;
    }


}
