package Impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Interfaces.Category;
import Interfaces.Configuration;
import Interfaces.PartType;

public class ConfigImpl extends ObservableImpl<ConfigImpl> implements Configuration {

	private Map<Category, PartType> catalogue = new HashMap<>();
	// private Map<Category, Set<PartType>> config = new HashMap<>();

	public ConfigImpl() {
		this.catalogue = new HashMap<>();
	}

	public ConfigImpl(Map<Category, PartType> catalogue) {
		this.catalogue = catalogue;
	}

	public Map<Category, PartType> getcatalogue() {
		return this.catalogue;
	}

	/**
	 * Add a part in the configuration
	 * 
	 * @param PartType
	 * @return true : added
	 * @return false : not added
	 */
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
	 * Remove a part in the configuration
	 * 
	 * @param PartType
	 * @return true : removed
	 * @return false : not removed
	 */
	public boolean RemovePart(PartType partype) {
		Category cat = partype.getCategory();
		if (catalogue.containsKey(cat) && catalogue.get(cat).getName().partName == partype.getName().partName) {
			catalogue.remove(cat);
			this.notifyObserver();
			return true;
		}
		return false;
	}

	/**
	 * 
	 * Test if the configuration is valid or not (4 != categories)
	 * 
	 * @return true : is valid
	 * @return false : is not valid
	 */
	public boolean isValid() {
		if (this.catalogue.size() != 4) {
			return false;
		} else {
			Boolean[] tabOfCategories = new Boolean[4];
			for (int i = 0; i < tabOfCategories.length; i++) {
				tabOfCategories[i] = false;
			}
			Collection<PartType> c = this.catalogue.values();
			for (PartType myPart : c) {
				Category cat = myPart.getCategory();
				if (cat.getCategoryString() == "Engine") {
					if (tabOfCategories[0] == true) {
						return false;
					} else
						tabOfCategories[0] = true;
				}
				if (cat.getCategoryString() == "Transmission") {
					if (tabOfCategories[1] == true) {
						return false;
					} else
						tabOfCategories[1] = true;
				}
				if (cat.getCategoryString() == "Exterior") {
					// System.out.println(tabOfCategories[2] == true);
					if (tabOfCategories[2] == true) {
						return false;
					} else
						tabOfCategories[2] = true;
				}
				if (cat.getCategoryString() == "Interior") {
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
	 * Show parts of the configuration
	 * 
	 * @return PartTypes of the configuration
	 */
	public Collection<PartType> getMyParts() {
		Collection<PartType> res;
		res = catalogue.values();
		return res;

	}

	/**
	 * Show a part from a category
	 * 
	 * @param Category
	 * @return PartType
	 */
	public PartType ShowMyPartFromCategory(Category cat) {
		if (catalogue.containsKey(cat)) {
			return catalogue.get(cat);
		}
		return null;
	}

	@Override
	public String toString() {
		return catalogue + "";
	}
}