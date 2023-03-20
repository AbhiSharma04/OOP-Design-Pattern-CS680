package edu.umb.cs680.hw03;

public class Car{

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

    public float GetMileage() {
        return mileage;
    }

    public int GetYear() {
        return year;
    }

    public float GetPrice() {
        return price;
    }

    public static void main(String[] args) {

    }
}