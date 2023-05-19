package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EuclideanTest {


    Car Audi = new Car("audi","q3",12,2017,55000);
    Car Honda = new Car("Honda","City",10,2010,15000);
    Car Hyundai=new Car("Hyundai","Creta",15,2019,20000);
    Car Toyota= new Car("Toyota","Innova",11,2019,30000);
    Car Suzuki = new Car("Suzuki","Swift",16,2013,10000);
    List<List<Double>> carvalues= MinMaxNormalization.NormalizeCarsMinMax (Audi,Honda,Hyundai,Toyota,Suzuki);

    @Test
    public void CheckcarValuesbyMatrixEuclidean(){
        List<List<Double>> expected= List.of( List.of(0.0, 1.227262335243029, 0.950957931590205, 0.6211299937499416, 1.2813958438523108), List.of(1.227262335243029, 0.0, 1.3064417795894274, 1.0671873729054748, 1.0599324460188286), List.of(0.950957931590205, 1.3064417795894274, 0.0, 0.7027283689263065, 0.7222222222222223),  List.of(0.6211299937499416, 1.0671873729054748, 0.7027283689263065, 0.0, 1.156036224815823),  List.of(1.2813958438523108, 1.0599324460188286, 0.7222222222222223, 1.156036224815823, 0.0));
        Euclidean euc= new Euclidean();
        List<List<Double>> mat= Distance.matrix(carvalues,euc);
        assertEquals(expected,mat);
    }

    @Test
    public void CheckDistancefor2points(){
        Euclidean euc= new Euclidean();
        double expected =1.2813958438523108;
        double distanceeuc= euc.distance(carvalues.get(0),carvalues.get(4));
        assertEquals(expected,distanceeuc);
    }

}