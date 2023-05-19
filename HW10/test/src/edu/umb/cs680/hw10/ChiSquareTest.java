package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ChiSquareTest {

    //@BeforeAll
    Car Audi = new Car("audi","q3",12,2017,55000);
    Car Honda = new Car("Honda","City",10,2010,15000);
    Car Hyundai=new Car("Hyundai","Creta",15,2019,20000);
    Car Toyota= new Car("Toyota","Innova",11,2019,30000);
    Car Suzuki = new Car("Suzuki","Swift",16,2013,10000);
    List<List<Double>> carvalues= MinMaxNormalization.NormalizeCarsMinMax (Audi,Honda,Hyundai,Toyota,Suzuki);


    @Test
    public void CheckcarValuesbyMatrixEuclidean(){
        List<List<Double>> expected= List.of(List.of(0.0, 0.911111111111111, 0.3685064935064935, 0.14850427350427353, 0.7555555555555556), List.of(0.911111111111111, 0.0, 0.9351851851851852, 0.6833333333333333, 0.7222222222222222), List.of(0.3685064935064935, 0.9351851851851852, 0.0, 0.2592592592592593, 0.28535353535353536), List.of(0.14850427350427353, 0.6833333333333333, 0.2592592592592593, 0.0, 0.6865079365079365), List.of(0.7555555555555556, 0.7222222222222222, 0.28535353535353536, 0.6865079365079365, 0.0));
        ChiSquare chi= new ChiSquare();
        List<List<Double>> mat= Distance.matrix(carvalues,chi);
        assertEquals(expected,mat);
    }

    @Test
    public void CheckDistancefor2points(){
        ChiSquare chi= new ChiSquare();
        double expected =0.7555555555555556;
        double distancechi= chi.distance(carvalues.get(0),carvalues.get(4));
        assertEquals(expected,distancechi);
    }



}