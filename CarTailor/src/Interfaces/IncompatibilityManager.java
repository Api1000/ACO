package Interfaces;

import java.util.ArrayList;
import java.util.Map;

public interface IncompatibilityManager {

	public Map<PartType, ArrayList<PartType>> getIncompatibilities();

	public Map<PartType, ArrayList<PartType>> getRequirements();

	/**
	 * Add a requirement between 2 parts
	 * @param partype, requirement
	 * @return true : added
	 * @return false : not added
	 */
	public boolean addRequirement(PartType partype, PartType requirement);

	/**
	 * Remove a requirement between 2 parts
	 * @param partype, requirement
	 * @return true : removed
	 * @return false : not removed
	 */
	public boolean removeRequirement(PartType partype, PartType requirement);

	/**
	 * Add an incompatibility between 2 parts
	 * @param partype, incompatibility
	 * @return true : added
	 * @return false : not added
	 */
	public boolean addIncompatibility(PartType partype, PartType incompatibility);

	/**
	 * Remove an incompatibility between 2 parts
	 * @param partype, incompatibility
	 * @return true : removed
	 * @return false : not removed
	 */
	public boolean removeIncompatibility(PartType partype, PartType incompatibility);

	/**
	 * Test if the incompatibilitymanager is valid or not 
	 * @return true : is valid
	 * @return false : is not valid
	 */
	public boolean isCompatible();
}
