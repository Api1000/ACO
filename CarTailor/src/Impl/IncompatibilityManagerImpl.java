package Impl;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import Interfaces.Configuration;
import Interfaces.IncompatibilityManager;
import Interfaces.PartType;

public class IncompatibilityManagerImpl implements IncompatibilityManager {

	private ConfigImpl config;
	private Map<PartType, ArrayList<PartType>> incompatibilities;
	private Map<PartType, ArrayList<PartType>> requirements;

	/**
	 * 
	 * @param config
	 * @see
	 */
	public IncompatibilityManagerImpl(ConfigImpl config) {
		this.config = config;
		this.incompatibilities = new HashMap<>();
		this.requirements = new HashMap<>();
	}

	public Map<PartType, ArrayList<PartType>> getIncompatibilities() {
		return this.incompatibilities;
	}

	public Map<PartType, ArrayList<PartType>> getRequirements() {
		return this.requirements;
	}

	/**
	 * Add a requirement between 2 parts
	 * @param partype, requirement
	 * @return true : added
	 * @return false : not added
	 */
	public boolean addRequirement(PartType partype, PartType requirement) {
		if (requirements.containsKey(partype)) {
			if (!requirements.get(partype).contains(requirement))
				return requirements.get(partype).add(requirement);
			else
				return false;
		} else {
			ArrayList<PartType> temp = new ArrayList<>();
			temp.add(requirement);
			requirements.put(partype, temp);
		}
		return true;

	}

	/**
	 * Remove a requirement between 2 parts
	 * @param partype, requirement
	 * @return true : removed
	 * @return false : not removed
	 */
	public boolean removeRequirement(PartType partype, PartType requirement) {
		if (requirements.containsKey(partype)) {
			if (requirements.get(partype).contains(requirement))
				return requirements.get(partype).remove(requirement);
		}
		return false;
	}

	/**
	 * Add an incompatibility between 2 parts
	 * @param partype, incompatibility
	 * @return true : added
	 * @return false : not added
	 */
	public boolean addIncompatibility(PartType partype, PartType incompatibility) {
		if (incompatibilities.containsKey(partype)) {
			if (!incompatibilities.get(partype).contains(incompatibility))
				return incompatibilities.get(partype).add(incompatibility);
			else
				return false;
		} else {
			ArrayList<PartType> temp = new ArrayList<>();
			temp.add(incompatibility);
			incompatibilities.put(partype, temp);
		}
		return true;

	}

	/**
	 * Remove an incompatibility between 2 parts
	 * @param partype, incompatibility
	 * @return true : removed
	 * @return false : not removed
	 */
	public boolean removeIncompatibility(PartType partype, PartType incompatibility) {
		if (incompatibilities.containsKey(partype)) {
			if (incompatibilities.get(partype).contains(incompatibility))
				return incompatibilities.get(partype).remove(incompatibility);
		}
		return false;

	}

	/**
	 * Test if the incompatibilitymanager is valid or not 
	 * @return true : is valid
	 * @return false : is not valid
	 */
	public boolean isCompatible() {
		Collection<PartType> myPartsConfig = config.getMyParts();
		Collection<String> myConfigString = new ArrayList<>();
		for (PartType p : myPartsConfig)
			myConfigString.add(p.getName().partName);

		// Convert PartType to String;
		Map<String, ArrayList<String>> incompatKeyToString = new HashMap<>();
		Map<String, ArrayList<String>> requireKeyToString = new HashMap<>();
		for (PartType p : this.incompatibilities.keySet()) {
			ArrayList<String> incompatValuesToString = new ArrayList<>();
			for (PartType p1 : this.incompatibilities.get(p))
				incompatValuesToString.add(p1.getName().partName);
			incompatKeyToString.put(p.getName().partName, incompatValuesToString);
		}
		for (PartType p : this.requirements.keySet()) {
			ArrayList<String> requireValuesToString = new ArrayList<>();
			for (PartType p1 : this.requirements.get(p))
				requireValuesToString.add(p1.getName().partName);
			requireKeyToString.put(p.getName().partName, requireValuesToString);
		}

		// End of conversion

		for (String p : myConfigString) {

			if (incompatKeyToString.containsKey(p)) {
				ArrayList<String> toCompare = incompatKeyToString.get(p);
				for (String s : toCompare) {
					if (myConfigString.contains(s))
						return false;
				}
			}
			if (requireKeyToString.containsKey(p)) {
				if (!myConfigString.containsAll(requireKeyToString.get(p))) {
					return false;
				}
			}
		}
		return true;

	}

	/**
	 * Change the configuration of the incompatibilitymanager
	 * @param Configuration
	 */
	public void ChangeConfig(Configuration c) {
		this.config = (ConfigImpl) c;
	}

	@Override
	public String toString() {
		return "\n  Incompatiblities = " + incompatibilities + "\n  Requirements = " + requirements;
	}

}
