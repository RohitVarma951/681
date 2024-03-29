package edu.umb.cs681.observer;

import java.util.LinkedList;
import java.util.List;

public abstract class Observable<T> {
	private LinkedList<Observer<T>> observers = new LinkedList<>();

	public void addObserver(Observer<T> o) {
		observers.add(o);
	}

	public void removeObserver(Observer<T> o) {
		observers.remove(o);
	}

	public int countObservers() {
		return observers.size();
	}

	public List<Observer<T>> getObservers(){
		return observers;
	}

	public void clearObservers() {
		observers.clear();
	}

	public void notifyObservers(T event) {
		observers.forEach( (observer)->{observer.update(this, event);} );
	}
}