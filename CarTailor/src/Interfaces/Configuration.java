package Interfaces;

import java.util.Set;
import java.util.Map;

import Impl.PartImpl;
import model.PartName;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public interface Configuration 
{
	
	public boolean AddPart(PartType p);


	public boolean RemovePart(PartType p);
	
	public Set<PartType> SelectCategory(Category c) ;


	public Set<PartType> ShowListofParts();
	
	
	public boolean isCompatible();

	public Set<PartType> getMyConfig();


	public boolean isValide() ;

	
	public Set<Category> ShowListCategory();

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */	
	public String toString() ;
	
	public  Map<Category,Set<PartType>> getCatalogue();

}

