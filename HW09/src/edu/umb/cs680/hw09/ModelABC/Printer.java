package edu.umb.cs680.hw09.ModelABC;

public class Printer {

    private static Printer singleton_instance =null;

    private Printer(){};

    public static Printer getInstance(){

        if (singleton_instance==null){
            singleton_instance= new Printer();
        }
        return singleton_instance;
    }

    public void print(){
        System.out.println("Welcome to printer's print");
    }

}
