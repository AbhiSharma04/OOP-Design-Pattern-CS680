package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ManhattanTest {

    Car Audi = new Car("audi","q3",12,2017,55000);
    Car Honda = new Car("Honda","City",10,2010,15000);
    Car Hyundai=new Car("Hyundai","Creta",15,2019,20000);
    Car Toyota= new Car("Toyota","Innova",11,2019,30000);
    Car Suzuki = new Car("Suzuki","Swift",16,2013,10000);

    List<List<Double>> carvalues= MinMaxNormalization.NormalizeCarsMinMax (Audi,Honda,Hyundai,Toyota,Suzuki);


     @Test
     public void CheckcarValuesbyMatrixManhattan(){

         List<List<Double>> expected = List.of(List.of(0.0, 2.0, 1.5, 0.9444444444444444, 2.111111111111111), List.of(2.0, 0.0, 1.9444444444444444, 1.5, 1.4444444444444444), List.of(1.5, 1.9444444444444444, 0.0, 0.888888888888889, 1.0555555555555556),List.of(0.9444444444444444, 1.5, 0.888888888888889, 0.0, 1.9444444444444444), List.of(2.111111111111111, 1.4444444444444444, 1.0555555555555556, 1.9444444444444444, 0.0));
         Manhattan man= new Manhattan();
         List<List<Double>> mat= Distance.matrix(carvalues,man);
        assertEquals(expected,mat);

 }

     @Test
     public void CheckDistancefor2points(){
      Manhattan man= new Manhattan();
      double expected =1.4444444444444444;
      double distanceman= man.distance(carvalues.get(1),carvalues.get(4));
      assertEquals(expected,distanceman);
 }

}