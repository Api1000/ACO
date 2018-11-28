package Impl;

import Interfaces.Requirements;

public class RequirementsImpl implements Requirements{
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public Requirements requirements;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public PartTypeImpl part;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public RequirementsImpl(){
		this.requirements = new RequirementsImpl();
	}
	
	public RequirementsImpl (Requirements requirement) {
		this.requirements = requirement;
	}

	public String getRequirement() {
		if(this.requirements != null)
			return this.requirements.toString();
		return null;
	}

	public void setRequirement(Requirements requirement) {
		this.requirements = requirement;
	}

	@Override
	public String toString() {
		return "Requirements [Requirement=" + this.requirements;
		//+ ", part=" + part + "]";
	}
	
}
