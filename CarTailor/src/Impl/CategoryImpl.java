package Impl;

import java.util.LinkedHashSet;

import Interfaces.Category;
import Interfaces.PartType;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class CategoryImpl implements Category {

	private String category;
	private LinkedHashSet<PartType> partImpl;

	public CategoryImpl() {
		super();
	}

	public CategoryImpl(String category) {
		this.category = category;
		this.partImpl = new LinkedHashSet<>();
	}

	public String getCategoryString() {
		return category;
	}

	public LinkedHashSet<PartType> getPartImpl() {
		return partImpl;
	}

	/**
	 * Add a part in its category
	 * 
	 * @param PartType
	 * @return true : added
	 * @return false : not added
	 */
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

	/**
	 * Remove a part in its category
	 * 
	 * @param PartType
	 * @return true : removed
	 * @return false : not removed
	 */
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

	@Override
	public String toString() {
		return "\n  " + category + " = " + partImpl;
	}
}
