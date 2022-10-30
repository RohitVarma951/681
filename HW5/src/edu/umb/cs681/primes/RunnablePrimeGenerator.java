package edu.umb.cs681.primes;

import java.util.LinkedList;

public class RunnablePrimeGenerator extends PrimeGenerator implements Runnable {

    public RunnablePrimeGenerator(long from, long to) {
        super(from, to);
    }

    public void run() {
        generatePrimes();
    }

    public static void main(String[] args) {
        LinkedList<Long> timeTaken = new LinkedList<Long>();
        long start=System.currentTimeMillis();
        RunnablePrimeGenerator gen1,gen2,gen3,gen4,gen5,gen6,gen7,gen8,gen9,gen10,gen11,gen12,gen13,gen14,gen15,gen16;
        gen1 = new RunnablePrimeGenerator(1L, 2000000L);
        Thread t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16;
        t1 = new Thread(gen1);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Using 1 Thread:");
        gen1.getPrimes().forEach( (Long prime)-> System.out.print(prime + ", ") );
        timeTaken.add(System.currentTimeMillis()-start);
        System.out.println("\nTime Elapsed:"+timeTaken.getLast());
        System.out.println("----------------------------------------------------");

        start = System.currentTimeMillis();
        gen1 = new RunnablePrimeGenerator(1L, 1000000L);
        gen2 = new RunnablePrimeGenerator(1000001L, 2000000L);
        t1 = new Thread(gen1);
        t2 = new Thread(gen2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nUsing 2 Threads:");
        gen1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        timeTaken.add(System.currentTimeMillis()-start);
        System.out.println("\nTime Elapsed:"+timeTaken.getLast());
        System.out.println("----------------------------------------------------");

        start = System.currentTimeMillis();
        gen1 = new RunnablePrimeGenerator(1L, 500000L);
        gen2 = new RunnablePrimeGenerator(500001L, 1000000L);
        gen3 = new RunnablePrimeGenerator(1000001L, 1500000L);
        gen4 = new RunnablePrimeGenerator(1500001L, 2000000L);
        t1 = new Thread(gen1);
        t2 = new Thread(gen2);
        t3 = new Thread(gen3);
        t4 = new Thread(gen4);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nUsing 4 Threads:");
        gen1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen3.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen4.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        timeTaken.add(System.currentTimeMillis()-start);
        System.out.println("\nTime Elapsed:"+timeTaken.getLast());
        System.out.println("----------------------------------------------------");

        start = System.currentTimeMillis();
        gen1 = new RunnablePrimeGenerator(1L, 250000L);
        gen2  = new RunnablePrimeGenerator(250000L, 500000L);
        gen3  = new RunnablePrimeGenerator(500000L,750000L);
        gen4 = new RunnablePrimeGenerator(750000L, 1000000L);
        gen5 = new RunnablePrimeGenerator(1000000L, 1250000L);
        gen6 = new RunnablePrimeGenerator(1250000L, 1500000L);
        gen7 = new RunnablePrimeGenerator(1500000L,1750000L);
        gen8 = new RunnablePrimeGenerator(1750000L, 2000000L);
        t1 = new Thread(gen1);
        t2 = new Thread(gen2);
        t3 = new Thread(gen3);
        t4 = new Thread(gen4);
        t5 = new Thread(gen5);
        t6 = new Thread(gen6);
        t7 = new Thread(gen7);
        t8 = new Thread(gen8);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nUsing 4 Threads:");
        gen1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen3.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen4.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen5.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen6.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen7.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen8.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        timeTaken.add(System.currentTimeMillis()-start);
        System.out.println("\nTime Elapsed:"+timeTaken.getLast());
        System.out.println("----------------------------------------------------");

        start = System.currentTimeMillis();
        gen1 = new RunnablePrimeGenerator(1L, 120000L);
        gen2  = new RunnablePrimeGenerator(120000L, 250000L);
        gen3  = new RunnablePrimeGenerator(250000L,370000L);
        gen4 = new RunnablePrimeGenerator(370000L, 500000L);
        gen5 = new RunnablePrimeGenerator(500000L, 620000L);
        gen6 = new RunnablePrimeGenerator(620000L, 750000L);
        gen7 = new RunnablePrimeGenerator(750000L,870000L);
        gen8 = new RunnablePrimeGenerator(870000L, 1000000L);
        gen9 = new RunnablePrimeGenerator(1000000L, 1120000L);
        gen10  = new RunnablePrimeGenerator(1120000L, 1250000L);
        gen11  = new RunnablePrimeGenerator(1250000L,1370000L);
        gen12 = new RunnablePrimeGenerator(1370000L, 1500000L);
        gen13 = new RunnablePrimeGenerator(1500000L, 1620000L);
        gen14 = new RunnablePrimeGenerator(1620000L, 1750000L);
        gen15 = new RunnablePrimeGenerator(1750000L,1870000L);
        gen16 = new RunnablePrimeGenerator(1870000L, 2000000L);
        t1 = new Thread(gen1);
        t2 = new Thread(gen2);
        t3 = new Thread(gen3);
        t4 = new Thread(gen4);
        t5 = new Thread(gen5);
        t6 = new Thread(gen6);
        t7 = new Thread(gen7);
        t8 = new Thread(gen8);
        t9 = new Thread(gen9);
        t10 = new Thread(gen10);
        t11 = new Thread(gen11);
        t12 = new Thread(gen12);
        t13 = new Thread(gen13);
        t14 = new Thread(gen14);
        t15 = new Thread(gen15);
        t16 = new Thread(gen16);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        t12.start();
        t13.start();
        t14.start();
        t15.start();
        t16.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
            t11.join();
            t12.join();
            t13.join();
            t14.join();
            t15.join();
            t16.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\nUsing 4 Threads:");
        gen1.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen2.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen3.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen4.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen5.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen6.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen7.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen8.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen9.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen10.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen11.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen12.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen13.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen14.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen15.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        gen16.getPrimes().forEach( (Long prime)->System.out.print(prime + ", ") );
        timeTaken.add(System.currentTimeMillis()-start);
        System.out.println("\nTime Elapsed:"+timeTaken.getLast());
        System.out.println("----------------------------------------------------");

        System.out.println("Overhead for Generating Primes using 1,2,4,8,16 Threads are (Respectively):");
        timeTaken.stream().forEach(System.out::println);
    }
}