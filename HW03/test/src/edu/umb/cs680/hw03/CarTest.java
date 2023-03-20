package edu.umb.cs680.hw03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    public String[] carToStringArray(Car C){
        String[] Carinfo = {C.GetMake(),C.GetModel(),String.valueOf(C.GetYear())};
        return Carinfo;
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear(){

        Car actual1;
        actual1 = new Car("Hyundai","Verna", 10,2013,25000);
        Car actual2 = new Car("Toyota","Fortuner",8,2019,45000);
        String [] expected1 = {"Hyundai","Verna","2013"};
        String [] expected2 = {"Toyota","Fortuner","2019"};
        assertArrayEquals(expected1,carToStringArray(actual1));
        assertArrayEquals(expected2,carToStringArray(actual2));

    }

}
