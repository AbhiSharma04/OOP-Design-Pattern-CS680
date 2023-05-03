package edu.umb.cs680.hw10;

import java.util.ArrayList;
import java.util.List;

public class MinMaxNormalization {
    public static List<Double> minMaxNormalize(List<Double> values) {
        double minValue = Double.MAX_VALUE;
        double maxValue = Double.MIN_VALUE;

        for (double value : values) {
            if (value < minValue) {
                minValue = value;
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }

        double range = maxValue - minValue;
        List<Double> normalizedValues = new ArrayList<>();

        for (double value : values) {
            double normalizedValue = (value - minValue) / range;
            normalizedValues.add(normalizedValue);
        }

        return normalizedValues;
    }

    public static List<List<Double>> CarNormalizedvalues() {

        List<Double> audi = List.of(1980.0, 9822.0, 23871.0);
        List<Double> honda = List.of(2280.0, 9422.0, 38387.0);
        List<Double> hyundai = List.of(3130.0, 12822.0, 18387.0);
        List<Double> toyota = List.of(1150.0, 6774.0, 16578.0);
        List<Double> suzuki = List.of(4537.0, 12980.0, 67895.0);

        List<Double> audinor = minMaxNormalize(audi);
        List<Double> hondanor = minMaxNormalize(honda);
        List<Double> hyundainor = minMaxNormalize(hyundai);
        List<Double> toyotanor = minMaxNormalize(toyota);
        List<Double> suzukinor = minMaxNormalize(suzuki);
        //System.out.println(audinor);

        List<List<Double>> carNormalizedvalues= List.of(audinor,hondanor,hyundainor,toyotanor,suzukinor);

        return carNormalizedvalues;
    }


}
