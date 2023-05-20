package edu.umb.cs680.hw15;

public class ThyristorPriceCalc implements PriceCalculate{
    @Override
    public double PriceCalculation (int Quantity) {
        return 5*Quantity;
    }
}
