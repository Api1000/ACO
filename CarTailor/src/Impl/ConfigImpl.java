package Impl;

import java.util.ArrayList;
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

public class ConfigImpl implements Configuration {

	public ArrayList<PartType> myConfig;
	public Map<Category, ArrayList<PartType>> catalogue = new HashMap<Category, ArrayList<PartType>>();

	public ConfigImpl() {
		this.myConfig = new ArrayList<PartType>();
	}

	public ConfigImpl(ArrayList<PartType> myConfig) {
		this.myConfig = myConfig;
		this.catalogue = new HashMap<Category, ArrayList<PartType>>();
	}

	public ConfigImpl(Map<Category, ArrayList<PartType>> myConfig) {
		this.catalogue = catalogue;
		this.myConfig = new ArrayList<PartType>();
	}

	public ConfigImpl(ArrayList<PartType> myConfig, Map<Category, ArrayList<PartType>> catalogue) {
		this.catalogue = catalogue;
		this.myConfig = myConfig;
	}

	public boolean AddPart(PartType p) {
		for (PartType part : this.myConfig) {
			if (part.getName().partName.equals(p.getName().partName)) {
				return false;
			}
		}
		for (ArrayList<PartType> setPT : catalogue.values()) {
			if (setPT.contains(p)) {
				PartType toAdd = p;
				this.myConfig.add(toAdd);
				return true;
			}
		}
		return false;
	}

	public boolean RemovePart(PartType p) {
		for (PartType part : this.myConfig) {
			if (part.getName().partName.equals(p.getName().partName)) {
				this.myConfig.remove(part);
				return true;
			}
		}
		return false;
	}

	public ArrayList<PartType> SelectCategory(Category c) { // a tester
		if (!catalogue.containsKey(c)) {
			throw new IllegalArgumentException("This category does not exist.");
		} else {
			return catalogue.get(c);
		}
	}

	public ArrayList<PartType> ShowListofParts() {
		if (catalogue.size() <= 0) {
			throw new IllegalArgumentException("There is no part in this config.");
		}
		ArrayList<PartType> setPart = new ArrayList<PartType>();
		for (ArrayList<PartType> sp : catalogue.values()) {
			for (PartType part : sp)
				setPart.add(part);
		}
		return setPart;
	}

	public boolean isCompatible() {
		ArrayList<PartType> set = this.myConfig;
		for (PartType myPart : set) {
			IncompatibilityManager myIncompat = myPart.getIm();
			if (myIncompat.getIncompatibilities() != null) {
				for (PartType incompatPart : myIncompat.getIncompatibilities()) {
					if (set.contains(incompatPart))
						return false;
				}
			}
			if (myIncompat.getRequirements() != null) {
				if (!set.containsAll(myIncompat.getRequirements())) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isValide() {
		if (this.myConfig.size() != 4) {
			return false;
		} else {
			Boolean[] tabOfCategories = new Boolean[4];
			for (PartType myPart : this.myConfig) {
				Category category = myPart.getCategory();
				if (category.getCategory() == "engine") {
					if (tabOfCategories[0] == true) {
						return false;
					} else
						tabOfCategories[0] = true;
				}
				if (category.getCategory() == "transmission") {
					if (tabOfCategories[1] == true) {
						return false;
					} else
						tabOfCategories[1] = true;
				}
				if (category.getCategory() == "exterior") {
					if (tabOfCategories[2] == true) {
						return false;
					} else
						tabOfCategories[2] = true;
				}
				if (category.getCategory() == "interior") {
					if (tabOfCategories[3] == true) {
						return false;
					} else
						tabOfCategories[3] = true;
				}
			}
			return isCompatible();
		}
	}

	public ArrayList<Category> ShowListCategory() {
		ArrayList<Category> keys = new ArrayList<Category>(catalogue.keySet());
		return keys;
	}

	public ArrayList<PartType> getMyConfig() {
		return this.myConfig;
	}

	public ArrayList<PartType> ShowListPartFromCategory(Category c) {
		if (catalogue.containsKey(c)) {
			throw new IllegalArgumentException("This category does not exist.");
		}
		return catalogue.get(c);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	public String toString() {
		String result = "My configuration is :\n";
		for (PartType part : this.myConfig) {
			result += part.toString() + "\n";
		}
		return result;
	}

	@Override
	public Map<Category, ArrayList<PartType>> getCatalogue() {
		return this.catalogue;
	}

}
