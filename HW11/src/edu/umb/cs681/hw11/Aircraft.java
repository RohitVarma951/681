package edu.umb.cs681.hw11;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class Aircraft {
    private AtomicReference<Position> position;
//    private ReentrantLock lock = new ReentrantLock();
//    private boolean done = false;
    public Aircraft(Position position){
        this.position = new AtomicReference<>(position);
    }
//    public void setPosition(double newLat, double newLong, double newAlt){
//        lock.lock();
//        try {
//            this.position = this.position.change(newLat, newLong, newAlt);
//        } finally {
//            lock.unlock();
//        }
//    }
    public Position getPosition(){
        return this.position.get();
    }
    public void setPosition(Position position){ this.position.set(position); }
}