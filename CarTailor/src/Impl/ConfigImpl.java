package Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import Interfaces.Configuration;
import Interfaces.Part;
import Interfaces.PartType;
import model.Catalogue;
import model.PartDescription;
import model.PartName;

public class ConfigImpl implements Configuration{
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	public ArrayList<PartImpl> myConfig;

	
	
	public ConfigImpl() {
		this.myConfig = new ArrayList<PartImpl>();
	}
	
	public ConfigImpl(ArrayList<PartImpl> MyPart) {
		this.myConfig = MyPart;
	}
	
	
	
	@SuppressWarnings("unlikely-arg-type")
	public boolean addPart(PartName pn) {
		Catalogue c = new Catalogue();
		PartImpl p = new PartImpl();
		for(int i=0;i < c.catalogue.length; i++) {
			if(c.catalogue[1][i].equals(p)) {
				p = new PartImpl(new CategoryImpl(c.catalogue[i][0]), new PartName(c.catalogue[i][1]), new PartDescription(c.catalogue[i][2]));
				myConfig.add(p);
				return true;
			}
		}
		return false;
	}


	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	
	
	public void showConfiguration() {
		ConfigImpl config = new ConfigImpl();
		config.getConfiguration();
		System.out.println(config);
	}
	
	
	public void showlistpartcategories() { //affiche les categories de MyPart
		
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

	public ArrayList<PartImpl> getConfiguration() {
		return this.myConfig;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */
	

	
	
}
