package edu.umb.cs681.observer;

public class DJIAObservable extends Observable<Double>{
	private double quote;
	
	public void changeQuote(double q) {
		quote = q;
		notifyObservers(quote);
	}
	
	public static void main(String args[]) {
		DJIAObservable observable = new DJIAObservable();
		observable.addObserver((Observable<Double> sender, Double event)->{
			System.out.println("Event: " + event + ", Sender: " + sender);
		});
		observable.addObserver((Observable<Double> sender, Double event)->{
			System.out.println("Event: " + event + ", Sender: " + sender);
		});
		observable.changeQuote(30000.44);
		observable.changeQuote(30050.99);
	}
}