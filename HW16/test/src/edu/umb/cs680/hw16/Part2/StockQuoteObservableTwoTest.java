package edu.umb.cs680.hw16.Part2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class StockQuoteObservableTwoTest {


    StockQuoteObservable s = new StockQuoteObservable ();

    Observer<StockEvent> UpdateLineChartObserver = (Observable<StockEvent> sender, StockEvent event) -> System.out.println("Line Chart Stock ticker=" + event.getTicker () + "quote:- " + event.getQuote());
    Observer<StockEvent> UpdateTableObserver = (Observable<StockEvent> sender, StockEvent event) -> System.out.println("Table Observer Stock ticker=" + event.getTicker () + "quote:- " + event.getQuote());
    Observer<StockEvent> UpdateThreeDObserver = (Observable<StockEvent> sender, StockEvent event) -> System.out.println("ThreeD Observer Stock ticker=" + event.getTicker () + "quote:- " + event.getQuote());

    @Test
    public void CountNoOfObservers(){
        s.addObserver (UpdateLineChartObserver);
        s.addObserver (UpdateTableObserver);
        s.addObserver (UpdateThreeDObserver);
        assertEquals (3,s.countObservers ());
    }

    @Test
    public void CheckClearObservers(){
        s.addObserver (UpdateLineChartObserver);
        s.addObserver (UpdateTableObserver);
        s.addObserver (UpdateThreeDObserver);
        s.clearObservers ();
        assertEquals (0,s.countObservers ());
    }

    @Test
    public void CheckNoOfObserversafteremove(){
        s.addObserver (UpdateLineChartObserver);
        s.addObserver (UpdateTableObserver);
        s.addObserver (UpdateThreeDObserver);

        s.removeObserver (UpdateThreeDObserver);
        assertEquals (2,s.countObservers ());
    }

    @Test
    public void CheckStockValueChange (){
        s.addObserver (UpdateLineChartObserver);
        s.addObserver (UpdateTableObserver);
        s.addObserver (UpdateThreeDObserver);
        s.map.put ("sharma",122.0);
        double prevvalue= s.map.get("sharma");
        s.map.put ("sharma",878.0);
        assertNotEquals(prevvalue,s.map.get ("sharma"));


    }



}