package edu.umb.cs680.hw10;

import java.util.List;

public class Manhattan implements DistanceMetric{
    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double sum = 0;
        int size = p1.size();

        for (int i = 0; i < size; i++) {
            sum += Math.abs(p2.get(i) - p1.get(i));
        }

        return sum;
    }

    public static void main(String[] args) {
        List<Double> p1= List.of(1.0,2.0,3.0);
        List<Double> p2= List.of(4.0,6.0,3.0);
        List<Double> p3= List.of(7.0,10.0,35.0);
        List<Double> p4= List.of(8.0,61.0,34.0);
        List<Double> p5= List.of(9.0,62.0,32.0);



        List<List<Double>> points = List.of(p1,p2,p3,p4);
        Distance dist= new Distance();
        Manhattan man= new Manhattan();
        Euclidean euc= new Euclidean();
        ChiSquare chi=new ChiSquare();
        double dista=dist.get(p1,p2,man);
        double dist_euc= dist.get(p1,p2,chi);
        double dist_chi= chi.distance(p1,p2);
        List<List<Double>> mat= dist.matrix(points,chi);
        //System.out.println(dista);
        System.out.println(dist_euc);
        System.out.println(mat);
        System.out.println(dist_chi);


    }
}
