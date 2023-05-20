package edu.umb.cs680.hw16.Part2;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable {

    public static Map<String, Double> map = new HashMap<>();

    public void changeQuote(String t, double q){
        map.put(t,q);
        this.notifyObservers(new StockEvent (t,q));
    }

}
