package Impl;

import java.util.Set;
import java.util.HashSet;
import java.util.Set;

import Interfaces.Category;
import Interfaces.PartType;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class CategoryImpl implements Category {

	private String category;
	private Set<PartType> partImpl;

	public CategoryImpl() {
		// this.category = new String();
		super();
	}

	public CategoryImpl(String category) {
		this.category = category;
		this.partImpl = new HashSet<>();
	}

	public CategoryImpl(String category, Set<PartType> partImpl) {
		this.category = category;
		this.partImpl = partImpl;
	}

	public String getCategoryString() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<PartType> getPartImpl() {
		return partImpl;
	}

	public void setPartImpl(Set<PartType> partImpl) {
		this.partImpl = partImpl;
	}

	public boolean addPartInCategory(PartType partCategory) {
		if (category.equals(partCategory.getCategory().getCategoryString())) {
			if (this.partImpl.contains(partCategory)) {
				return false;
			} else
				this.partImpl.add(partCategory);
			return true;
		}
		return false;
	}

	public boolean removePartInCategory(PartType partCategory) {
		if (category.equals(partCategory.getCategory().getCategoryString())) {
			if (!this.partImpl.contains(partCategory)) {
				return false;
			} else
				this.partImpl.remove(partCategory);
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	@Override
	public String toString() {
		return "\n  " + category + " = " + partImpl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

}
