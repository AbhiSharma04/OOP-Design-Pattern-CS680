package edu.umb.cs680.hw15;

public class ResistorPriceCalc implements PriceCalculate{
    @Override
    public double PriceCalculation (int Quantity) {
        return 10*Quantity;
    }
}
