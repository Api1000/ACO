package Impl;

import java.util.ArrayList;

import Interfaces.Configuration;
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
	
	
	
public boolean addPart(PartName pn) {
		Catalogue c = new Catalogue();
		PartImpl p = new PartImpl();
		for(PartImpl pi : this.myConfig) {
			if(pi.name.toString().equals(pn.partName.toString())) {
				return false;
			}
		}
		for(int i=0;i < c.catalogue.length; i++) {
			if(pn.partName.toString().equals(c.catalogue[i][1])) {
				//System.out.println("coucou");
				p = new PartImpl(new CategoryImpl(c.catalogue[i][0]), new PartName(c.catalogue[i][1]), new PartDescription(c.catalogue[i][2]));
				this.myConfig.add(p);
				return true;
			}
		}
		return false;
	}

	public boolean removePart(PartName pn) {
		Catalogue c = new Catalogue();
		for(int i=0; i<c.catalogue.length; i++) {
			if(!pn.partName.toString().equals(c.catalogue[i][1])) {
				return false;
			}
			else {
				myConfig.remove(i);
			}
		}
		return true;
	}




	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 * @ordered
	 */


	public void showConfiguration() {
		for(PartImpl p : myConfig) {
			System.out.print(p.category +" "+ p.name+ " " + p.description+ " " + p.im + "\n");
		}
	}


	public void showPartCategories() { //affiche les categories de MyPart
		for(PartImpl p: myConfig) {
			System.out.print(p.category + "\n");
		}
	}
	
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
