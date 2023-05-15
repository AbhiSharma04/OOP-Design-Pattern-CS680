package edu.umb.cs680.hw09.ModelABC;

import edu.umb.cs680.hw09.ModelABC.Printer;
import edu.umb.cs680.hw09.PrintingFramework.Command;

public class PrintJob implements Command {


    public void PrintJob(){
        System.out.println("Welcome to Printjob's Constructor");
    }

    Printer print = Printer.getInstance();
    @Override
    public void execute() {
        print.print();
        System.out.println("Welcome to Printjob's Execute");
    }
}
