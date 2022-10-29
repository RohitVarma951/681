package edu.umb.cs681.factorizer;

import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeFactorizer extends RunnablePrimeFactorizer {
    private ReentrantLock lock = new ReentrantLock();
    private boolean done = false;
    public RunnableCancellablePrimeFactorizer(long number){super(number);}
    public void run(){generatePrimeFactors();}
    public void setDone(){
        lock.lock();
        try {
            done = false;
        } finally {
            lock.unlock();
        }
    }
    public void generatePrimeFactors(){
        long k=number;
        for(long factor=2; k != 1 && factor <= to ;){
            lock.lock();
            try {
                if (k % factor == 0) {
                    factors.add(factor);
                    k /= factor;
                } else factor = Long.parseLong(BigInteger.valueOf(factor).nextProbablePrime().toString());
            }finally{ lock.unlock(); }
        }
    }
    public static void main(String args[]) {
        RunnableCancellablePrimeFactorizer rCPFactor = new RunnableCancellablePrimeFactorizer(5040);
        long start = System.currentTimeMillis();
        Thread t = new Thread(rCPFactor);
        t.start();
        rCPFactor.setDone();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Prime Factors :"+rCPFactor.getPrimeFactors());
        System.out.println("\nTime Taken is :"+(System.currentTimeMillis()-start));
    }
}
