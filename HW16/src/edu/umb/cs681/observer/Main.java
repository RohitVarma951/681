package edu.umb.cs681.observer;

import com.sun.net.httpserver.Request;

public class Main implements Runnable{
    public void run(){
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
        System.out.println(MetaCode+" changed");
        s.changeQuote(MetaCode, MetaValue);
    }
    public static void main(String[] args) throws InterruptedException {
        Main m[] = new Main[10];
        Thread t[] = new Thread[10];
        int i;
        for(i=0;i<10;i++)
            t[i] = new Thread(m[i]);
        for(i=0;i<10;i++)
            t[i].start();
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        for(i=0;i<10;i++)
            t[i].interrupt();
    }
}