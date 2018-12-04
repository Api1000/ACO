package Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Interfaces.Category;
import Interfaces.Configuration;
import Interfaces.IncompatibilityManager;
import Interfaces.Part;
import Interfaces.PartType;
import model.Catalogue;
import model.PartDescription;
import model.PartName;

public class ConfigImpl implements Configuration{
	
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  Engined-user-doc  -->
	 * @gEngineerated
	 * @ordered
	 */
	public ArrayList<Part> myConfig;
	public Map<Category,ArrayList<Part>> catalogue = new HashMap<Category,ArrayList<Part>>();
	
	
	/*public ConfigImpl() {
		this.myConfig = new ArrayList<PartImpl>();
	}
	
	public ConfigImpl(ArrayList<PartImpl> MyPart) {
		this.myConfig = MyPart;
	}*/
	
	
		
	
	public ConfigImpl() {
		this.myConfig = new ArrayList<Part>();
	}
	
	public ConfigImpl(ArrayList<Part> MyPart) {
		this.myConfig = MyPart;
	}
	
	public ArrayList<Part> getConfiguration() {
		return this.myConfig;
	}

	

	public Map<Category, ArrayList<Part>> getCatalogue() {
		return catalogue;
	}

	
public boolean addPart(PartName pn) {
		Catalogue c = new Catalogue();
<<<<<<< HEAD
		Part p = new PartImpl();
		for(Part pi : this.myConfig) {
			if(pi.getName().toString().equals(pn.partName.toString())) {
=======
		PartImpl p = new PartImpl();
		for(PartImpl pi : this.myConfig) {
			if(pi.name.toString().equals(pn.partName.toString())) {
>>>>>>> branch 'master' of https://github.com/Api1000/ACO
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
<<<<<<< HEAD
}
=======
	}
>>>>>>> branch 'master' of https://github.com/Api1000/ACO

<<<<<<< HEAD
=======


>>>>>>> branch 'master' of https://github.com/Api1000/ACO

	/**
	 * <!-- begin-user-doc -->
	 * <!--  Engined-user-doc  -->
	 * @gEngineerated
	 * @ordered
	 */


	public void showConfiguration() {
<<<<<<< HEAD
		ConfigImpl config = new ConfigImpl();
		config.getConfiguration();
		System.out.println(config);
	}
	
	
	
	public ArrayList<Part> selectCategory(Category category) {
		assert catalogue.containsKey(category) : "La categorie n'existe pas";
		return catalogue.get(category);
		}

	
	
	
	public boolean isvalidconfiguration() {
		if(this.myConfig.size() != 4) {
			return false;
		}
		else {
			Boolean[] tab = new Boolean[4];
			for(Part part : this.myConfig) {
				Category cat = part.getCategory();
				if(cat.getCategory() == "Engine") {
					if(tab[0] == true) {
						return false;
					}
					else
						tab[0] = true;
				}
				if(cat.getCategory() == "Transmission") {
					if(tab[1] == true) {
						return false;
					}
					else
						tab[1] = true;
				}
				if(cat.getCategory() == "Exterior") {
					if(tab[2] == true) {
						return false;
					}
					else
						tab[2] = true;
				}
				if(cat.getCategory() == "Interior") {
					if(tab[3] == true) {
						return false;
					}
					else
					tab[3] = true;
				}
			}
			return iscompatible();
=======
		for(PartImpl p : myConfig) {
			System.out.print(p.category +" "+ p.name+ " " + p.description+ " " + p.im + "\n");
>>>>>>> branch 'master' of https://github.com/Api1000/ACO
		}
	}


	public void showPartCategories() { //affiche les categories de MyPart
		for(PartImpl p: myConfig) {
			System.out.print(p.category + "\n");
		}
	}
	
	public boolean iscompatible() {
		ArrayList<Part> config = this.myConfig;
		for(Part myPart : config) {
			IncompatibilityManager incomp = myPart.getIm();
			if(incomp.getIncompatibilities() != null) {
				for(Part incompatPart : incomp.getIncompatibilities()) {
					if(config.contains(incompatPart))
						return false;
				}
			}
			if(incomp.getRequirements() != null) {
					if(!config.containsAll(incomp.getRequirements())) {
						return false;
					}
				}
		 }
		 return true;
	}

	
	public Set<Category> showlistpartcategories() { //affiche les categories de MyPart
		return catalogue.keySet();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  Engined-user-doc  -->
	 * @gEngineerated
	 * @ordered
	 */
	
	public void selectcategory() {
		// TODO implemEnginet me
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  Engined-user-doc  -->
	 * @gEngineerated
	 * @ordered
	 */
	
	public void selectpartcategory() {
		// TODO implemEnginet me
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!--  Engined-user-doc  -->
	 * @gEngineerated
	 * @ordered
	 */
	

	/**
	 * <!-- begin-user-doc -->
	 * <!--  Engined-user-doc  -->
	 * @gEngineerated
	 * @ordered
	 */
	

	@Override
	public String toString() {
		return "ConfigImpl [myConfig=" + myConfig + "]";
	}


//>>>>>>> branch 'master' of https://github.com/Api1000/ACO

	/**
	 * <!-- begin-user-doc -->
	 * <!--  Engined-user-doc  -->
	 * @gEngineerated
	 * @ordered
	 */
	

	
	
}
