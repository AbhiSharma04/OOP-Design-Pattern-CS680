package edu.umb.cs680.hw09;

public class PrintJob implements Command{


    public void PrintJob(){
        System.out.println("Welcome to Printjob's Constructor");
    }

    Printer print = new Printer();
    @Override
    public void execute() {
        print.print();
        System.out.println("Welcome to Printjob's Execute");
    }
}
