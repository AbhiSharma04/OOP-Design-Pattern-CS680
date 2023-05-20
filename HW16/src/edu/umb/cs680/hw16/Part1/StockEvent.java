package edu.umb.cs680.hw16.Part1;

public class StockEvent {

    public static String ticker;
    public static double quote;

    public  StockEvent(String t, double q){
    ticker= t;
    quote=q;
    }


    public String getTicker(){
        return ticker;
    }

    public static double getQuote() {
        return quote;
    }
}
