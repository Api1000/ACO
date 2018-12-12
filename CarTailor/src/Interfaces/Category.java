package Interfaces;

import java.util.LinkedHashSet;

public interface Category {

	/**
	 * Add a part in its category
	 * 
	 * @param PartType
	 * @return true : added
	 * @return false : not added
	 */
	public boolean addPartInCategory(PartType partCategory);

	/**
	 * Remove a part in its category
	 * 
	 * @param PartType
	 * @return true : removed
	 * @return false : not removed
	 */
	public boolean removePartInCategory(PartType partCategory);

	public String getCategoryString();

	public LinkedHashSet<PartType> getPartImpl();
}
