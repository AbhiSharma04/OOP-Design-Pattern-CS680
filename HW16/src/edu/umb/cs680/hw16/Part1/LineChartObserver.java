package edu.umb.cs680.hw16.Part1;

public class LineChartObserver implements Observer<StockEvent>{
    @Override
    public void update (Observable<StockEvent> sender, StockEvent event) {
        System.out.println ("Line Chart Stock ticker=" + event.getTicker () + "quote:- "+ event.getQuote ());
    }
}
