package edu.umb.cs681.primes;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
    private ReentrantLock lock = new ReentrantLock();
    private boolean done = false;
    public RunnableCancellablePrimeGenerator(long from, long to) {
        super(from, to);
    }
    public void run(){generatePrimes();}
    public void setDone(){
        lock.lock();
        try {
            done = false;
        } finally {
            lock.unlock();
        }
    }

    public void generatePrimes(){
        for (long n = from; n <= to; n++) {
            lock.lock();
            try {
                if (done) {
                    System.out.println("Stopped prime number generation.");
                    this.primes.clear();
                    break;
                }
                if (isPrime(n)) {
                    this.primes.add(n);
                }
            }finally{
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        RunnableCancellablePrimeGenerator rCPGen = new RunnableCancellablePrimeGenerator(101,898);
        long start = System.currentTimeMillis();
        Thread t = new Thread(rCPGen);
        t.start();
        rCPGen.setDone();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        rCPGen.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
        System.out.println("\nTime Taken is :"+(System.currentTimeMillis()-start));
    }
}