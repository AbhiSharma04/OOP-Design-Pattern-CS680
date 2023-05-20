package edu.umb.cs680.hw16.Part1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class StockQuoteObservableOneTest {

    StockQuoteObservable s = new StockQuoteObservable ();
    LineChartObserver line= new LineChartObserver ();
    TableObserver tableObserver =  new TableObserver ();
    ThreeDObserver threeD =new ThreeDObserver();




    @Test
    public void CountNoOfObservers(){
        s.addObserver (line);
        s.addObserver (tableObserver);
        s.addObserver (threeD);
        Assertions.assertEquals (3,s.countObservers ());
    }

    @Test
    public void CheckChangeOfStockValue(){
        s.addObserver (line);
        s.addObserver (tableObserver);
        s.addObserver (threeD);

        s.map.put ("abc",123.0);

        double expected = 123.0;

        Assertions.assertEquals (expected,s.map.get ("abc"));



    }
    @Test
    public void CheckClearObservers(){
        s.addObserver (line);
        s.addObserver (tableObserver);
        s.addObserver (threeD);
        s.clearObservers ();
        Assertions.assertEquals (0,s.countObservers ());
    }

    @Test
    public void CheckRemoveObservers(){
        s.addObserver (line);
        s.addObserver (tableObserver);
        s.addObserver (threeD);

        s.removeObserver (line);

        Assertions.assertFalse (s.getObservers ().contains (line));
    }

    @Test
    public void ChangeStockValue () throws InterruptedException {
        Random ran= new Random ();
        double add = 0;
        do {
            if ( add > 100 )
                add = 0;
            Thread.sleep ((20));
            add = add + ran.nextInt (5);
            s.changeQuote ("Abhi", add);
        } while (add < 50);
        Assertions.assertTrue (s.map.size ()>0);
    }


}