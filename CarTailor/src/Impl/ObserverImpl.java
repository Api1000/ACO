package Impl;

import Interfaces.Observable;
import Interfaces.Observer;

public class ObserverImpl<T> implements Observer<T>{

	@Override
	public String update(Observable<T> o) {
		System.out.println("update");
		return "update";
	}
}
