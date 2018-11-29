package Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import Interfaces.Configuration;
import Interfaces.Part;
import Interfaces.PartType;

public class ConfigImpl implements Configuration{
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public ArrayList<PartImpl> MyPart;

	
	
	public ConfigImpl() {
		this.MyPart = new ArrayList<PartImpl>();
	}
	
	public ConfigImpl(ArrayList<PartImpl> MyPart) {
		this.MyPart = MyPart;
	}
	
	public boolean addPart(PartName part) {
		
	}

	
	
	public Configuration getconfiguration() {
		Configuration config = new ConfigImpl();
		for(Part PT : this.MyPart) {
			config.addpart(PT);
		}
		return config;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	public void showlistpartcategories() { //affiche les categories de MyPart
		Configuration config = getconfiguration();
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
