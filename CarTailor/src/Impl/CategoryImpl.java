package Impl;
import java.util.Set;
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
	public Set<PartType> partImpl;


	public CategoryImpl(){
		this.category = new String();
	}
	

	public CategoryImpl(String category) {
		this.category = category;
		this.partImpl = new HashSet<PartType>();
	}
	
	public CategoryImpl(String category,  Set<PartType> partImpl) {
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

	

	public Set<PartType> getPartImpl() {
		return this.partImpl;
	}




	@Override
	public String toString() {
		return  "\n" + category;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	
}

