package umb.edu.cs681.singleton;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton {
    private ConcurrentSingleton(){}
    private static ConcurrentSingleton instance = null;
    private static final ReentrantLock lock = new ReentrantLock();

    public static ConcurrentSingleton getInstance(){
        lock.lock();
        try{
            if(instance==null)
                instance = new ConcurrentSingleton();
            return instance;
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args){
        for(int i=0;i<5;i++)
            new Thread(()->{System.out.println(ConcurrentSingleton.getInstance());}).start();
    }
}
