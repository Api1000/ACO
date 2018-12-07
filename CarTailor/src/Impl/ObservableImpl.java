package Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Interfaces.Observable;
import Interfaces.Observer;

public class ObservableImpl<T> implements Observable<T> {

	private Collection<Observer<T>> myObserver;

	public ObservableImpl() {
		myObserver = new ArrayList<Observer<T>>();
	}

	@Override
	public void register(Observer<T> o) {
		myObserver.add(o);
	}

	@Override
	public void unregister(Observer<T> o) {
		myObserver.remove(o);
	}

	@Override
	public boolean isRegister(Observer<T> o) {
		return myObserver.contains(o);
	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(Object v) {
		// TODO Auto-generated method stub
	}

	@Override
	public void notifyObserver() {
		Iterator<Observer<T>> it = myObserver.iterator();
		while (it.hasNext()) {
			it.next().update(this);
		}
	}

}
