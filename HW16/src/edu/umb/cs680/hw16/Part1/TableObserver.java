package edu.umb.cs680.hw16.Part1;

public class TableObserver implements Observer<StockEvent>{
    @Override
    public void update(Observable sender, StockEvent event) {

        System.out.println ("Table Stock ticker=" +event.getTicker () + "quote:- "+ event.getQuote ());

    }
}
