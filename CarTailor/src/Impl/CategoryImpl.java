package Impl;
import java.util.HashSet;
import java.util.Set;

import Interfaces.Category;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public class CategoryImpl implements Category {
	String category;


	public CategoryImpl(){
		this.category = new String();
	}
	

	public CategoryImpl(String category) {
		this.category = category;
	}
	
	
	public boolean removeCategory(String category) {
		// TODO implement me
		return false;
	}
	
	
	public boolean addCategory(String category) {
		// TODO implement me
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public String getCategory() {
		return this.category;
	}


	@Override
	public String toString() {
		return  "[" + category + "]" ;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	


	
	
}

