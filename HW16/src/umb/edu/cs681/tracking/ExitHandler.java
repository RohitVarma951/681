package umb.edu.cs681.tracking;

import java.util.concurrent.locks.ReentrantLock;

public class ExitHandler implements Runnable {

    private AdmissionMonitor control;
    private ReentrantLock lock = new ReentrantLock();
    private boolean done = false;


    public ExitHandler(AdmissionMonitor control) {
        this.control = control;
    }

    public void setDone() {
        lock.lock();
        try {
            done = true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        while(true) {
            lock.lock();
            try {
                if(done) {
                    System.out.println("ExitHandler setDone!");
                    break;
                }
            }
            finally {
                lock.unlock();
            }
            control.exit();
            try{
                Thread.sleep(150);
            } catch(InterruptedException e) {
                System.out.println(e);
                continue;
            }
        }
    }

}