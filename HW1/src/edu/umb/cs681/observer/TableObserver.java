package edu.umb.cs681.observer;

public class TableObserver implements Observer<Double>{
	public void update(Observable<Double> sender, Double event) {
		System.out.println("Event: " + event + ", Sender: " + sender);
	}
}
