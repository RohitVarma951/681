package edu.umb.cs681.observer;

public class Working {
    public static void main(String args[]) {
        StockQuoteObservable s = new StockQuoteObservable();

        s.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float quote = ((StockEvent) obj).getQuote();
            System.out.println("Observer 1 - Stock event: " + ticker + " " + quote);
        });

        s.addObserver((Observable o, Object obj) -> {
            String ticker = ((StockEvent) obj).getTicker();
            Float quote = ((StockEvent) obj).getQuote();
            System.out.println("Observer 2 - Stock event: " + ticker + " " + quote);
        });

        System.out.println("Number of observers: " + s.countObservers());


        String MetaCode = "META";
        Float MetaValue = 10.5f;

        System.out.println("Add new Stock: " + MetaCode);
        s.setQuote(MetaCode, MetaValue);

        MetaValue = 20.0f;
        System.out.println(MetaCode + " changed");
        s.changeQuote(MetaCode, MetaValue);
    }
}
