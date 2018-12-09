package Impl;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import Interfaces.Configuration;
import Interfaces.IncompatibilityManager;
import model.Catalogue;
import model.PartName;
import Interfaces.PartType;

public class IncompatibilityManagerImpl implements IncompatibilityManager {

	private ConfigImpl config;
	private HashMap<PartType, ArrayList<PartType>> incompatibilities;
	private HashMap<PartType, ArrayList<PartType>> requirements;

	public IncompatibilityManagerImpl(ConfigImpl config) {
		this.config = config;
		this.incompatibilities = new HashMap<PartType, ArrayList<PartType>>();
		this.requirements = new HashMap<PartType, ArrayList<PartType>>();
	}

	public IncompatibilityManagerImpl(HashMap<PartType, ArrayList<PartType>> incompatibilities,
			HashMap<PartType, ArrayList<PartType>> requirements, ConfigImpl config) {
		this.config = config;
		this.incompatibilities = incompatibilities;
		this.requirements = requirements;
	}

	public HashMap<PartType, ArrayList<PartType>> getIncompatibilities() {
		return this.incompatibilities;
	}

	public HashMap<PartType, ArrayList<PartType>> getRequirements() {
		return this.requirements;
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean addRequirement(PartType partype, PartType requirement) {
		if (!partype.equals(requirements)) {
			throw new IllegalArgumentException("This part already contains all this requirements");
		}
		if (requirements.containsKey(partype)) {
			if (!requirements.get(partype).contains(requirement))
				requirements.get(partype).add(requirement);
			else
				return false;
		} else {
			ArrayList<PartType> temp = new ArrayList<>();
			temp.add(requirement);
			requirements.put(partype, temp);
		}
		return true;

	}

	public boolean removeRequirement(PartType partype, PartType requirement) {
		if (requirements.containsKey(partype)) {
			if (requirements.get(partype).contains(requirement))
				return requirements.get(partype).remove(requirement);
		}
		return false;
	}

	@SuppressWarnings("unlikely-arg-type")
	public boolean addIncompatibility(PartType partype, PartType incompatibility) {
		if (!partype.equals(this.incompatibilities)) {
			throw new IllegalArgumentException("This part already contains all this incompatibilities");
		}
		if (incompatibilities.containsKey(partype)) {
			if (!incompatibilities.get(partype).contains(incompatibility))
				incompatibilities.get(partype).add(incompatibility);
			else
				return false;
		} else {
			ArrayList<PartType> temp = new ArrayList<>();
			temp.add(incompatibility);
			incompatibilities.put(partype, temp);
		}
		return true;

	}

	public boolean removeIncompatibility(PartType partype, PartType incompatibility) {
		if (incompatibilities.containsKey(partype)) {
			if (incompatibilities.get(partype).contains(incompatibility))
				return incompatibilities.get(partype).remove(incompatibility);
		}
		return false;

	}

	public boolean isCompatible() {
		Collection<PartType> myPartsConfig = config.getcatalogue().values();
		for (PartType p : myPartsConfig) {
			if (incompatibilities.containsKey(p)) {
				Collection<PartType> incompat = incompatibilities.get(p);
				for (PartType incompatPart : myPartsConfig) {
					if (incompat.contains(incompatPart))
						return false;
				}
			}
			if (requirements.containsKey(p)) {
				if (!myPartsConfig.containsAll(requirements.get(p))) {
					return false;
				}
			}
		}
		return true;

	}
	
	public void ChangeConfig(Configuration c){
		this.config = (ConfigImpl) c;
	}


	@Override
	public String toString() {
		return "Incompatiblity =" + incompatibilities + ", Requirement =" + requirements;
	}

}
