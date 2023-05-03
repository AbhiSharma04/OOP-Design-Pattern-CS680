package edu.umb.cs680.hw11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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

        public void setDominationCount(List<Car> Cars){
            DominationCount=0;
            for (Car car: Cars){
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
//            edu.umb.cs680.hw11.Car verna = new edu.umb.cs680.hw11.Car("Hyundai","Verna", 10,2013,25000);
//            edu.umb.cs680.hw11.Car Fortuner = new Car("Toyota","Fortuner",8,2019,45000);
//            edu.umb.cs680.hw11.Car audi = new Car("audi","q3",12,2017,50000);
//            edu.umb.cs680.hw11.Car swift = new Car("Suzuki","Swift",16,2015,15000);
//            edu.umb.cs680.hw11.Car city = new Car("Honda","city",13,2010,20000);
//
////            List<Car> carsList = List.of(verna,Fortuner,audi,swift,city);
//            List<Car> carsList = new ArrayList<Car>();
//            carsList=List.of()
//            carsList.add(verna);
//            carsList.add(Fortuner);
//            carsList.add(audi);
//            carsList.add(swift);
//            carsList.add(city);
//
//
//
//            Collections.sort(carsList,new PriceComparator());
            System.out.println("carsList");


        }
    }

