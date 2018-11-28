package Impl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Interfaces.Category;
import Interfaces.Part;
import Interfaces.PartType;
import model.Description;
import Interfaces.Incompatibilities;
import Interfaces.Requirements;
import model.Name;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class PartTypeImpl implements PartType
{
	public Category category;
	public Name name;
	public Description description;
	public Incompatibilities incompatibility;
	public Requirements requirements;
	
	
	public Set<Part> partType;
	
	public String Tab;



	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public PartTypeImpl(){
		super();
	}
	
	public PartTypeImpl(Name name, Description description, Category category, Incompatibilities incompatibility,Requirements requirements ) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.incompatibility = incompatibility;
		this.requirements = requirements;
	}

}

