package edu.umb.cs680.hw13;

import java.util.List;

public class Car {


        private String make,model;
        private int mileage,year,DominationCount;
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

        public void setDominationCount(List<edu.umb.cs680.hw13.Car> Cars){
            DominationCount=0;
            for (edu.umb.cs680.hw13.Car car: Cars){
                if(this.GetPrice()<=car.GetPrice()&&this.GetMileage()>=car.GetMileage()&&this.GetYear()>=car.GetYear()){
                    if(this.GetPrice()<car.GetPrice()||this.GetMileage()>car.GetMileage()||this.GetYear()>car.GetYear()){
                        DominationCount++;
                    }
                }

            }
        }

        public int getDominationCount(){

            return DominationCount;
        }

        public static void main(String[] args) {
               System.out.println("Welcome to Car Class");
        }
    }



