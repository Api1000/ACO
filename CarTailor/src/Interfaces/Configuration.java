package Interfaces;

import java.util.ArrayList;
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
	
	public ArrayList<PartType> SelectCategory(Category c) ;


	public ArrayList<PartType> ShowListofParts();
	
	
	public boolean isCompatible();




	public boolean isValide() ;

	
	public ArrayList<Category> ShowListCategory();

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */	
	public String toString() ;
	
	public  Map<Category,ArrayList<PartType>> getCatalogue();

}

