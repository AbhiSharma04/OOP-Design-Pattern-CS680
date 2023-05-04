package edu.umb.cs680.hw10;

public class Car {
    private String make,model;
    private int mileage,year;
    private float price ;


    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make; this.model = model; this.mileage = mileage; this.year = year; this.price = price;
    }


    public String GetMake() {
        return make;
    }

    public String GetModel() {
        return model;
    }

    public double GetMileage() {
        return mileage;
    }

    public double GetYear() {
        return year;
    }

    public double GetPrice() {
        return price;
    }

}
