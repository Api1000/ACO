package Impl;

import java.util.Set;
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

	public Set<PartType> Parts;
	public Map<Category, Set<PartType>> catalogue = new HashMap<Category, Set<PartType>>();

	public ConfigImpl() {
		//this.Parts = new HashSet<PartType>();
		this.catalogue = new HashMap<Category, Set<PartType>>();
	}

	public ConfigImpl(Set<PartType> Parts) {
		this.Parts = Parts;
		this.catalogue = new HashMap<Category, Set<PartType>>();
	}

	public ConfigImpl(Map<Category, Set<PartType>> Parts) {
		this.catalogue = catalogue;
		this.Parts = new HashSet<PartType>();
	}

	public ConfigImpl(Set<PartType> Parts, Map<Category, Set<PartType>> catalogue) {
		this.catalogue = catalogue;
		this.Parts = Parts;
	}

	public boolean AddPart(PartType p) {
		for (PartType part : this.Parts) {
			if (part.getName().partName.equals(p.getName().partName)) {
				return false;
			}
		}
		for (Set<PartType> setPT : catalogue.values()) {
			if (setPT.contains(p)) {
				//PartType toAdd = p;
				this.Parts.add(p);
				return true;
			}
		}
		return false;
	}

	public boolean RemovePart(PartType p) {
		for (PartType part : this.Parts) {
			if (part.getName().partName.equals(p.getName().partName)) {
				this.Parts.remove(part);
				return true;
			}
		}
		return false;
	}

	public Set<PartType> SelectCategory(Category c) { // a tester
		if (!catalogue.containsKey(c)) {
			throw new IllegalArgumentException("This category does not exist.");
		} else {
			return catalogue.get(c);
		}
	}

	public Set<PartType> ShowListofParts() {
		if (catalogue.size() <= 0) {
			throw new IllegalArgumentException("There is no part in this config.");
		}
		Set<PartType> setPart = new HashSet<PartType>();;
		for (Set<PartType> sp : catalogue.values()) {
			for (PartType part : sp)
				setPart.add(part);
		}
		return setPart;
	}

	public boolean isCompatible() {
		Set<PartType> set = this.Parts;
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
		if (this.Parts.size() != 4) {
			return false;
		} else {
			Boolean[] tabOfCategories = new Boolean[4];
			for (PartType myPart : this.Parts) {
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

	public Set<Category> ShowListCategory() {
		Set<Category> keys = new HashSet<Category>(catalogue.keySet());
		return keys;
	}

	public Set<PartType> getParts() {
		return this.Parts;
	}

	public Set<PartType> ShowListPartFromCategory(Category c) {
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
		for (PartType part : this.Parts) {
			result += part.toString() + "\n";
		}
		return result;
	}

	
	@Override
	public Map<Category, Set<PartType>> getCatalogue() {
		return this.catalogue;
	}

}
