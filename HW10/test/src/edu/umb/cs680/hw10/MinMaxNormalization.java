package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMaxNormalization {
    public static List<Double> minMaxNormalize(List<Double> values) {
        double minValue = Collections.min(values);
        double maxValue = Collections.max(values);

        double range = maxValue - minValue;
        List<Double> normalizedValues = new ArrayList<>();

        for (double value : values) {
            double normalizedValue = (value - minValue) / range;
            normalizedValues.add(normalizedValue);
        }

        return normalizedValues;
    }

    public static List<Double> carValuesToList(Car C){
        return List.of(C.GetMileage(),C.GetPrice(),C.GetYear());
    }


    public static List<List<Double>> CarNormalizedvalues() {

        Car Audi = new Car("audi","q3",12,2017,55000);
        Car Honda = new Car("Honda","City",10,2010,15000);
        Car Hyundai=new Car("Hyundai","Creta",15,2019,20000);
        Car Toyoya= new Car("Toyota","Innova",11,2019,30000);
        Car Suzuki = new Car("Suzuki","Swift",16,2013,10000);

        List<Double> audinor = minMaxNormalize(carValuesToList(Audi));
        List<Double> hondanor = minMaxNormalize(carValuesToList(Honda));
        List<Double> hyundainor = minMaxNormalize(carValuesToList(Hyundai));
        List<Double> toyotanor = minMaxNormalize(carValuesToList(Toyoya));
        List<Double> suzukinor = minMaxNormalize(carValuesToList(Suzuki));

        List<List<Double>> carNormalizedvalues= List.of(audinor,hondanor,hyundainor,toyotanor,suzukinor);

        return carNormalizedvalues;
    }

    public static void main(String[] args) {
        MinMaxNormalization m= new MinMaxNormalization();
        m.CarNormalizedvalues();
    }


}
