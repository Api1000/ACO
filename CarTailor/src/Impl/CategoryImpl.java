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
	Category category;


	public CategoryImpl(){
		super();
	}
	

	public CategoryImpl(Category category) {
		this.category = category;
	}
	
	public boolean addcategory(Category category) {
		// TODO implement me
		return false;
	}


	
	public boolean removecategory(Category category) {
		// TODO implement me
		return false;
	}


	public Category getCategory() {
		return this.category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}

