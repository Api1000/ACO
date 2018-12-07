package Impl;

import java.util.HashSet;
import java.util.Set;

import Interfaces.IncompatibilityManager;
import model.Catalogue;
import model.PartName;
import Interfaces.PartType;

public class IncompatibilityManagerImpl implements IncompatibilityManager {
	public Set<PartType> incompatibilities;
	public Set<PartType> requirements;

	public IncompatibilityManagerImpl() {
		this.incompatibilities = new HashSet<PartType>();
		this.requirements = new HashSet<PartType>();
	}

	public IncompatibilityManagerImpl(Set<PartType> incompatibilities, Set<PartType> requirements) {
		this.incompatibilities = incompatibilities;
		this.requirements = requirements;
	}

	public Set<PartType> getIncompatibilities() {
		return this.incompatibilities;
	}

	public Set<PartType> getRequirements() {
		return this.requirements;
	}

	public boolean addRequirement(PartType requirement, PartType p) {
		if (!requirement.equals(this.requirements)) {
			throw new IllegalArgumentException("This part already contains all this requirements");
		}
		
		
		for (PartType partype : requirement) {
			partype.getName(p).add(requirement);
			if (!this.requirements.contains(partype)) {
				this.requirements.add(partype);
			}
		}
		return true;
	}

	public boolean removeRequirement(PartType requirement, PartType p) {
		for (PartType partype : requirement) {
			if (this.requirements.contains(partype)) {
				this.requirements.remove(partype);
			}
		}
		return true;
	}

	public boolean addIncompatibility(SetPartType incompatibility, PartType p) {
		if (!incompatibility.equals(this.incompatibilities)) {
			throw new IllegalArgumentException("This part already contains all this incompatibilities");
		}
		for (PartType partype : incompatibility) {
			if (!this.incompatibilities.contains(partype)) {
				this.requirements.add(partype);
			}
		}
		return true;
	}

	public boolean removeIncompatibility(PartType incompatibility, PartType p) {
		for (PartType partype : incompatibility) {
			if (this.incompatibilities.contains(partype)) {
				this.incompatibilities.remove(partype);
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Incompatiblity =" + incompatibilities + ", Requirement =" + requirements;
	}

}
