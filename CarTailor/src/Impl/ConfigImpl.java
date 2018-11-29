package Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import Interfaces.Configuration;
import Interfaces.Part;
import Interfaces.PartType;
import model.PartName;

public class ConfigImpl implements Configuration{
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public ArrayList<PartImpl> MyConfig;

	
	
	public ConfigImpl() {
		this.MyConfig = new ArrayList<PartImpl>();
	}
	
	public ConfigImpl(ArrayList<PartImpl> MyPart) {
		this.MyConfig = MyPart;
	}
	
	public boolean addPart(PartName part) {
		return false;
	}
	
	public boolean removePart(PartName part) {
		return false;
	}

	
	
	
	public ArrayList<PartImpl> getConfiguration() {
		return MyConfig;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void showlistpartcategories() { //affiche les categories de MyPart
		ConfigImpl config = new ConfigImpl();
		config.getConfiguration();
		System.out.println(config);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void selectcategory() {
		// TODO implement me
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void selectpartcategory() {
		// TODO implement me
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public boolean isvalidconfiguration() {
		// TODO implement me
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public boolean isincompatible() {
		// TODO implement me
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	

	
	
}
