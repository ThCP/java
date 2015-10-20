package counter;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;

public class Counter extends Observable {
	
	private int value;
	
	public void increment(){
		value++;
//		notifyChange();
		setChanged();
	}
	
	public void decrement() throws Exception {
		if(value==0) //return;
			throw new Exception("Cannot decrement a zero counter!");
		value--;
		//notifyChange();
		setChanged();
	}
	
	public int getValue(){
		return value;
	}
	
	// ALL the following is already inmplemented in Observable
	private List<CounterObserver> observers = new LinkedList<>();
	public void addObserver( CounterObserver obs){
		observers.add(obs);
	}
	private void notifyChange(){
		observers.forEach( obs -> obs.valueChanged(this) );
	}
	
	public interface CounterObserver {
		void valueChanged(Counter source);
	}

}
