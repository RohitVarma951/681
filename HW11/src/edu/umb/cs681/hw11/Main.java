package edu.umb.cs681.hw11;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Main implements Runnable{
//    private final ReentrantLock lock = new ReentrantLock();
//    private boolean done = false;
//    public void setDone(){
//        lock.lock();
//        try {
//            done = false;
//        } finally {
//            lock.unlock();
//        }
//    }

    public void run(){
        List<Double> coordinateList;
        Aircraft plane = new Aircraft(new Position(42.3601,-71.0589,0));
        System.out.println("The Aircraft's Starting Position is : "+ plane.getPosition());
        coordinateList = plane.getPosition().coordinate();
        System.out.println("The Aircraft's Starting coordinates are : " + coordinateList.get(0)
                + " " + coordinateList.get(1)
                + " " + coordinateList.get(2));
        plane.setPosition(new Position(40.778944,-72.069688,10000));
        System.out.println("The Aircraft's Current Position is : " + plane.getPosition());
        coordinateList = plane.getPosition().coordinate();
        System.out.println("The Aircraft's Current coordinates are : " + coordinateList.get(0)
                + " " + coordinateList.get(1)
                + " " + coordinateList.get(2));
        System.out.println("Displacement so far is : " + plane.getPosition().distanceTo(new Position(42.3601,-71.0589,0)));
    }

    public static void main(String[] args){
        Thread t1,t2,t3;
        t1 = new Thread(new Main());
        t2 = new Thread(new Main());
        t3 = new Thread(new Main());

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}