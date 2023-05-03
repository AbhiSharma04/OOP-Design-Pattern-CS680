package edu.umb.cs680.hw10;

import java.util.List;

public class ChiSquare implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double diff,sum,dist=0.0;
        assert (p1.size() == p2.size()) : "Dimensions must agree.";

        if(p1.size()==p2.size()) {

            for (int i = 0; i < p1.size(); i++) {

                diff = p1.get(i) - p2.get(i);
                sum = p1.get(i) + p2.get(i);

                if (sum > 0.0)
                    dist += (diff * diff) / sum;
            }
        }

        return 0.5 * dist;
    }

    }

