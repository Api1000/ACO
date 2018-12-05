package Impl;

import java.util.ArrayList;

import Interfaces.IncompatibilityManager;
import model.Catalogue;
import model.PartName;
import Interfaces.PartType;

public class IncompatibilityManagerImpl implements IncompatibilityManager {
	public ArrayList<PartType> incompatibility;
	public ArrayList<PartType> requirement;

	public IncompatibilityManagerImpl() {
		this.incompatibility = new ArrayList<PartType>();
		this.requirement = new ArrayList<PartType>();
	}

	public IncompatibilityManagerImpl(ArrayList<PartType> incompatibility, ArrayList<PartType> requirement) {
		this.incompatibility = incompatibility;
		this.requirement = requirement;
	}

	public ArrayList<PartType> getIncompatibilities() {
		return this.incompatibility;
	}

	public ArrayList<PartType> getRequirements() {
		return this.requirement;
	}

	public boolean addRequirement(ArrayList<PartType> requirement) {
		for (PartType partype : requirement) {
			if (!this.requirement.contains(partype)) {
				this.requirement.add(partype);
			}
		}
		return true;
	}

	public boolean removeRequirement(ArrayList<PartType> requirement) {
		for (PartType partype : requirement) {
			if (this.requirement.contains(partype)) {
				this.requirement.remove(partype);
			}
		}
		return true;
	}

	public boolean addIncompatibility(ArrayList<PartType> incompatibility) {
		for (PartType partype : incompatibility) {
			if (!this.incompatibility.contains(partype)) {
				this.requirement.add(partype);
			}
		}
		return true;
	}

	public boolean removeIncompatibility(ArrayList<PartType> incompatibility) {
		for (PartType partype : incompatibility) {
			if (this.incompatibility.contains(partype)) {
				this.incompatibility.remove(partype);
			}
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	@Override
	public String toString() {
		return "[" + incompatibility + "," + requirement + "]";
	}

}
