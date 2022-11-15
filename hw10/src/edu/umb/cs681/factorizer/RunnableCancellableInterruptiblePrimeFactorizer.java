package edu.umb.cs681.factorizer;

import java.math.BigInteger;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer{
    private final ReentrantLock lock = new ReentrantLock();
    public RunnableCancellableInterruptiblePrimeFactorizer(long number){super (number);}

    public ReentrantLock getLock(){
        return lock;
    }

    public void generateFactors(){
        long k=number;
        for(long factor=2; k != 1 && factor <= to ;){
            lock.lock();
            if(Thread.interrupted()){
                System.out.println("Stopped");
                this.factors.clear();
                break;
            }
            if(k % factor == 0) {
                factors.add(factor);
                k /= factor;
            }
            else {
                factor= Long.parseLong( BigInteger.valueOf(factor).nextProbablePrime().toString() );
            }
            lock.unlock();
        }
    }

    public void run(){
        generateFactors();
    }

    public static void main(String[] args) {
        RunnableCancellableInterruptiblePrimeFactorizer rCPFactor = new RunnableCancellableInterruptiblePrimeFactorizer(5040);
        long start = System.currentTimeMillis();
        Thread t = new Thread(rCPFactor);
        t.start();
        rCPFactor.getLock().lock();
        t.interrupt();
        rCPFactor.getLock().unlock();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Prime Factors :"+rCPFactor.getPrimeFactors());
        System.out.println("\nTime Taken is :"+(System.currentTimeMillis()-start));
    }
}
