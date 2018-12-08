package Impl;

import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import Interfaces.Category;
import Interfaces.Configuration;
import Interfaces.IncompatibilityManager;
import Interfaces.PartType;
import model.Catalogue;
import model.PartDescription;
import model.PartName;
import Interfaces.Observable;

public class ConfigImpl extends ObservableImpl<ConfigImpl> implements Configuration {

	//public Set<PartType> Parts;
	public Map<Category, PartType> catalogue = new HashMap<Category, PartType>();
	public Map<Category, Set<PartType>> config = new HashMap<Category, Set<PartType>>();


	public ConfigImpl() {
		// this.Parts = new HashSet<PartType>();
		this.catalogue = new HashMap<Category, PartType>();
	}

	public ConfigImpl(Map<Category, PartType> catalogue) {
		this.catalogue = catalogue;
	}

	/*public ConfigImpl(Map<Category, Set<PartType>> config) {
		this.config = config;
	}*/

	public Map<Category, PartType> getcatalogue() {
		return this.catalogue;
	}
	


	public boolean AddPart(PartType pt) {
		Category cat = pt.getCategory();
		if (catalogue.containsKey(cat)) {
			return false;
		} else {
			catalogue.put(cat, pt);
			this.notifyObserver();
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public boolean RemovePart(PartType partype) {
		Category cat = partype.getCategory();
		if (catalogue.containsKey(cat)
				&& catalogue.get(cat).getName().partName == partype.getName().partName) {
			catalogue.remove(cat);
			this.notifyObserver();
			return true;
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public boolean isValid() {
		if (this.catalogue.size() != 4) {
			return false;
		} else {
			Boolean[] tabOfCategories = new Boolean[4];
			Collection<PartType> c = this.catalogue.values();
			for (PartType myPart : c) {
				Category cat = myPart.getCategory();
				if (cat.getCategory() == "Engine") {
					if (tabOfCategories[0] == true) {
						return false;
					} else
						tabOfCategories[0] = true;
				}
				if (cat.getCategory() == "Transmission") {
					if (tabOfCategories[1] == true) {
						return false;
					} else
						tabOfCategories[1] = true;
				}
				if (cat.getCategory() == "Exterior") {
					if (tabOfCategories[2] == true) {
						return false;
					} else
						tabOfCategories[2] = true;
				}
				if (cat.getCategory() == "Interior") {
					if (tabOfCategories[3] == true) {
						return false;
					} else
						tabOfCategories[3] = true;
				}
			}
			return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public Collection<PartType> getMyParts() {
		Collection<PartType> res = new HashSet<PartType>();
		res = catalogue.values();
		return res;
		
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public PartType ShowMyPartFromCategory(Category parameter) {
		if (catalogue.containsKey(parameter)) {
			return catalogue.get(parameter);
		} else {
			return null;
		}
	}

	/*public String toString() {
		String result = "My configuration :\n";
		Set<PartType> myparts = (Set<PartType>) catalogue.values();
		for(PartType partI : myparts) {
			result += partI.toString() +"\n";
		}
		return result;
	}*/

	@Override
	public String toString() {
		return "MyConfig = \n " + catalogue + "\n";
	}
}