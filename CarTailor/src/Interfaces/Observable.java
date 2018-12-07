package Interfaces;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public interface Observable<T> {
	void register(Observer<T> o);

	void unregister(Observer<T> o);

	boolean isRegister(Observer<T> o);

	T getValue();

	void setValue(T v);

	void notifyObserver();
}

/*
 * public Observable(){ super(); }
 **
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 * 
 * @ordered
 *
 * 
 * public Observer register() { // TODO implement me return null; }
 **
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 * 
 * @ordered
 *
 * 
 * public Observer unregister() { // TODO implement me return null; }
 **
 * 
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 * 
 * @ordered
 *
 * 
 * public boolean isRegistered() { // TODO implement me return false; }
 * 
 * }
 */
