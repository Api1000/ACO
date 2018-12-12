package Interfaces;


import java.util.Collection;
import java.util.Map;



/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public interface Configuration {

	/**
	 * Add a part in the configuration
	 * 
	 * @param PartType
	 * @return true : added
	 * @return false : not added
	 */
	public boolean AddPart(PartType pT);

	/**
	 * Remove a part in the configuration
	 * 
	 * @param PartType
	 * @return true : removed
	 * @return false : not removed
	 */
	public boolean RemovePart(PartType pT);

	/**
	 * Show a part from a category
	 * 
	 * @param Category
	 * @return PartType
	 */
	public PartType ShowMyPartFromCategory(Category cat);

	/**
	 * 
	 * Test if the configuration is valid or not (4 != categories)
	 * 
	 * @return true : is valid
	 * @return false : is not valid
	 */
	public boolean isValid();

	public Map<Category, PartType> getcatalogue();

	/**
	 * Show parts of the configuration
	 * 
	 * @return PartTypes of the configuration
	 */
	public Collection<PartType> getMyParts();

}
