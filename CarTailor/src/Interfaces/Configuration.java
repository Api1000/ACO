package Interfaces;

import java.util.ArrayList;
import java.util.Set;

import Impl.CategoryImpl;
import Impl.PartImpl;
import model.PartName;

/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public interface Configuration 
{
	

	public boolean addPart(PartName pn);

	
	
	public ArrayList<Part> getConfiguration() ;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
<<<<<<< HEAD
	public Set<Category> showlistpartcategories() ;
=======
	public void showPartCategories();
>>>>>>> branch 'master' of https://github.com/Api1000/ACO

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void selectcategory() ;
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void selectpartcategory();

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public boolean isvalidconfiguration() ;

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public boolean iscompatible();
}

