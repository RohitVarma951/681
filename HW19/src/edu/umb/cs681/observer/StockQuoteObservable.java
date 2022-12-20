package edu.umb.cs681.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class StockQuoteObservable extends Observable{
    private Map<String, Float> quote = new HashMap<>();
    private ReentrantLock lockTQ = new ReentrantLock();

    public void setQuote(String t, Float q) {
        lockTQ.lock();
        quote.put(t, q);
        setChanged();
        notifyObservers(new StockEvent(t, q));
        lockTQ.unlock();
    }

    public void changeQuote(String t, Float q) {
        lockTQ.lock();
        quote.put(t, q);
        setChanged();
        notifyObservers(new StockEvent(t, q));
        lockTQ.unlock();
    }
}