package practice.observer;

import java.util.ArrayList;

// observer needs to register with observable
interface IObserver{
	void update();
}

interface IObservable{
	int state = 0;
	void add(IObserver observer);
	void remove(IObserver observer);
	void notifyObserver();
	int getState();
}


class A implements IObserver{
	IObservable observed;
	
	public A(IObservable a){
		observed = a;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("UPdate Called");
		System.out.println("Current State : " + observed.getState());
	}

}

class B implements IObserver{
IObservable observed;
	
	public B(IObservable a){
		observed = a;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("UPdate Called");
		System.out.println("Current State of observed : " + observed.getState());
	}

}


class Station implements IObservable{
	private int state;
	private ArrayList<IObserver> observers = new ArrayList<>(); 
	
	public void changeState() {
		state++;
		notifyObserver();	
	}
	@Override
	public void add(IObserver observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	@Override
	public void remove(IObserver observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (IObserver iObserver : observers) {
			iObserver.update();
		}
		
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return state;
	}
	
}


public class ObserverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Station station = new Station();
		
		IObserver a = new A(station);
		station.add(a);
		
		IObserver b = new B(station);
		station.add(b);
		
		int count = 5;
		while(count-- > 0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			station.changeState();
		}
		
		station.remove(b);
		
		count = 5;
		while(count-- > 0){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			station.changeState();
		}
		
		
	}

}

/* 
// OUTPUT
UPdate Called
Current State : 1
UPdate Called
Current State of observed : 1
UPdate Called
Current State : 2
UPdate Called
Current State of observed : 2
UPdate Called
Current State : 3
UPdate Called
Current State of observed : 3
UPdate Called
Current State : 4
UPdate Called
Current State of observed : 4
UPdate Called
Current State : 5
UPdate Called
Current State of observed : 5
UPdate Called
Current State : 6
UPdate Called
Current State : 7
UPdate Called
Current State : 8
UPdate Called
Current State : 9
UPdate Called
Current State : 10
*/