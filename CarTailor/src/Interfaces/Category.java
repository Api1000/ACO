package Interfaces;

import java.util.Set;

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
		

		public String getCategoryString();
		
		public Set<PartType> getPartImpl();
	}



