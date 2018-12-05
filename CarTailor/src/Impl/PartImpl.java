package Impl;

import Interfaces.Part;
import Interfaces.PartType;
import model.PartDescription;
import model.PartName;
import Interfaces.IncompatibilityManager;

import java.util.Set;

import Interfaces.Category;

public class PartImpl implements Part{
	
	
	public Category category;
	public PartName name;
	public PartDescription description;
	public IncompatibilityManagerImpl ir;

	public Set<Part> partType;

	public String Tab;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PartImpl() {
		super();
	}

	public PartImpl(PartName name, PartDescription description, Category category, IncompatibilityManagerImpl ir) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.ir = ir;
	}



}
