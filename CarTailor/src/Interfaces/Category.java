package Interfaces;

import java.util.ArrayList;

public interface Category {

	/**
		 * <!-- begin-user-doc -->
		 * <!--  end-user-doc  -->
		 * @generated
		*/


		/**
		 * <!-- begin-user-doc -->
		 * <!--  end-user-doc  -->
		 * @generated
		 * @ordered
		 */
		
		public boolean addCategory(PartType partCategory); 

		/**
		 * <!-- begin-user-doc -->
		 * <!--  end-user-doc  -->
		 * @generated
		 * @ordered
		 */
		
		public boolean removeCategory(PartType partCategory); 
		

		public String getCategory();
		
		public ArrayList<PartType> getPartImpl();
	}



