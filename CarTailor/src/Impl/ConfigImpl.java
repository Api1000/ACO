package Impl;

import java.util.ArrayList;
import java.util.Arrays;

import Interfaces.Configuration;
import Interfaces.PartType;

public class ConfigImpl implements Configuration{
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public ArrayList<PartTypeImpl> MyPart;
	
	
	public ConfigImpl() {
		this.MyPart = new ArrayList<PartTypeImpl>();
	}
	
	public ConfigImpl(ArrayList<PartTypeImpl> MyPart) {
		this.MyPart = MyPart;
	}
	
	
	public Configuration getconfiguration() {
		Configuration config = new ConfigImpl();
		for(PartTypeImpl PT : this.MyPart) {
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
	
	public boolean removepart(PartTypeImpl parttype) {
		//PartType part = new PartType(new Name(), new Description(), new CategoryImpl());
		for(PartType PT : this.MyPart) {
			if(PT.equals(parttype)) {
				MyPart.remove(PT);
				return true;
			}
		}
		return false;
	}

	

	public boolean addpart(PartTypeImpl parttype) {
		//System.out.println("coin");
		Boolean result = false;
		result = MyPart.add(parttype);
		return result;
	}
	
	@Override
	public String toString() {
		String result="";
		for(PartTypeImpl PT : this.MyPart) {
			result += PT.Name.Name + " " + PT.Description.Description + " " + PT.CategoryImpl.CategoryImpl + "\n";
		}
		return result;
	}
}
