package Impl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Interfaces.Category;
import Interfaces.Part;
import Interfaces.PartType;
import model.PartDescription;
import model.PartName;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class PartTypeImpl implements PartType
{
	public Category category;
	public PartName name;
	public PartDescription description;
	public IncompatibilityManagerImpl ir;

	
	
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
	
	public PartTypeImpl(PartName name, PartDescription description, Category category, IncompatibilityManagerImpl ir ) {
		this.name = name;
		this.description = description;
		this.category = category;
		this.ir = ir;
	}

}

