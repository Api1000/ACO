package Impl;

import java.util.HashSet;
import java.util.Set;

import Interfaces.IncompatibilityManager;
import model.Catalogue;
import model.PartName;
import Interfaces.PartType;

public class IncompatibilityManagerImpl implements IncompatibilityManager {
	public Set<PartType> incompatibility;
	public Set<PartType> requirement;

	public IncompatibilityManagerImpl() {
		this.incompatibility = new HashSet<PartType>();
		this.requirement = new HashSet<PartType>();
	}

	public IncompatibilityManagerImpl(Set<PartType> incompatibility, Set<PartType> requirement) {
		this.incompatibility = incompatibility;
		this.requirement = requirement;
	}

	public Set<PartType> getIncompatibilities() {
		return this.incompatibility;
	}

	public Set<PartType> getRequirements() {
		return this.requirement;
	}

	public boolean addRequirement(Set<PartType> requirement) {
		if (!requirement.equals(this.requirement)) {
			throw new IllegalArgumentException("This part already contains all this requirements");
		}
		for (PartType partype : requirement) {
			if (!this.requirement.contains(partype)) {
				this.requirement.add(partype);
			}
		}
		return true;
	}

	public boolean removeRequirement(Set<PartType> requirement) {
		for (PartType partype : requirement) {
			if (this.requirement.contains(partype)) {
				this.requirement.remove(partype);
			}
		}
		return true;
	}

	public boolean addIncompatibility(Set<PartType> incompatibility) {
		if (!incompatibility.equals(this.incompatibility)) {
			throw new IllegalArgumentException("This part already contains all this incompatibilities");
		}
		for (PartType partype : incompatibility) {
			if (!this.incompatibility.contains(partype)) {
				this.requirement.add(partype);
			}
		}
		return true;
	}

	public boolean removeIncompatibility(Set<PartType> incompatibility) {
		for (PartType partype : incompatibility) {
			if (this.incompatibility.contains(partype)) {
				this.incompatibility.remove(partype);
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Incompatiblity =" + incompatibility + ", Requirement =" + requirement;
	}

}
