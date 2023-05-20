package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectriclItemsTest {


    PriceCalculate coil= new CoilPriceCalc ();
    PriceCalculate Thyristor= new ThyristorPriceCalc ();
    PriceCalculate Resistor= new ResistorPriceCalc ();

    PriceCalculate coilLE = q -> 3.5 * q;
    PriceCalculate ThyristorLE = q -> 5.0 * q;
    PriceCalculate ResistorLE = q -> 10.0 * q;

    @Test
    public void CheckPriceofCoil(){
        double expected= 175.0;
        assertEquals (expected,coil.PriceCalculation (50));
    }

    @Test
    public void CheckPriceofThyristor(){
        double expected= 250.0;
        assertEquals (expected,Thyristor.PriceCalculation (50));
    }

    @Test
    public void CheckPriceofResistor(){
        double expected= 500.0;
        assertEquals (expected,Resistor.PriceCalculation (50));
    }

    @Test
    public void CheckPriceofCoilUsingLE(){
        double expected= 175.0;
        assertEquals (expected,coilLE.PriceCalculation (50));
    }

    @Test
    public void CheckPriceofThyristorUsingLE(){
        double expected= 125.0;
        assertEquals (expected,ThyristorLE.PriceCalculation (25));
    }

    @Test
    public void CheckPriceofResistorUsingLE(){
        double expected= 1000.0;
        assertEquals (expected,ResistorLE.PriceCalculation (100));
    }

}