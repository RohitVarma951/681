package edu.umb.cs681.observer;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Observable<T> {
    private AtomicBoolean changed = new AtomicBoolean(false);
    private ReentrantLock lock = new ReentrantLock();
    private ConcurrentLinkedQueue<Observer> observers = new ConcurrentLinkedQueue<>();

    public void addObserver(Observer<T> o) {
        lock.lock();
        observers.add(o);
        lock.unlock();
    }

    public void removeObserver(Observer<T> o) {
        lock.lock();
        observers.remove(o);
        lock.unlock();
    }

    public int countObservers() {
        lock.lock();
        int size = observers.size();
        lock.unlock();
        return size;
    }

    public ConcurrentLinkedQueue<Observer> getObservers(){
        lock.lock();
        ConcurrentLinkedQueue<Observer> ob = observers;
        lock.unlock();
        return ob;
    }

    public void clearObservers() {
        lock.lock();
        observers.clear();
        lock.unlock();
    }

    public void notifyObservers(T event) {
        lock.lock();
        ConcurrentLinkedQueue<Observer> ob = observers;
        lock.unlock();
        ob.forEach( (observer)->{observer.update(this, event);} );
    }

    protected void setChanged(){
        changed.set(true);
    }

    protected void clearChanged(){
        changed.set(false);
    }

    public boolean hasChanged(){
        return changed.get();
    }
}