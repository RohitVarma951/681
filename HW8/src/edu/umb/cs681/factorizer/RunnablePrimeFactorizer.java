package edu.umb.cs681.factorizer;

public abstract class RunnablePrimeFactorizer extends PrimeFactorizer implements Runnable {
    public RunnablePrimeFactorizer(long number){
        super(number);
    }
}