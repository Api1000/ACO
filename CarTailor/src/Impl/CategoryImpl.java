package Impl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Interfaces.Category;
import Interfaces.PartType;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */
public class CategoryImpl implements Category {
	
	public String category;
	public ArrayList<PartType> partImpl;


	public CategoryImpl(){
		this.category = new String();
	}
	

	public CategoryImpl(String category) {
		this.category = category;
		this.partImpl = new ArrayList<PartType>();
	}
	
	public CategoryImpl(String category,  ArrayList<PartType> partImpl) {
		// TODO Auto-generated constructor stub
		this.category = category;
		this.partImpl = partImpl;
	}

	
	public boolean removeCategory(PartType partCategory) {
		if (!this.partImpl.contains(partCategory)){
			return false;
		}
		else
			this.partImpl.remove(partCategory);
		return true;

	}
	
	
	public boolean addCategory(PartType partCategory) {
		if (this.partImpl.contains(partCategory)){
			return false;
		}
		else
			this.partImpl.add(partCategory);
		return true;

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

	

	public ArrayList<PartType> getPartImpl() {
		return this.partImpl;
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

