package edu.umb.cs680.hw15;

public class CoilPriceCalc implements PriceCalculate{
    @Override
    public double PriceCalculation (int Quantity) {
        return 3.5*Quantity;
    }
}
