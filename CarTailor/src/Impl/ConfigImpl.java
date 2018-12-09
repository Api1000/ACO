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

	private Map<Category, PartType> catalogue = new HashMap<>();
	//private Map<Category, Set<PartType>> config = new HashMap<>();


	public ConfigImpl() {
		this.catalogue = new HashMap<>();
	}

	public ConfigImpl(Map<Category, PartType> catalogue) {
		this.catalogue = catalogue;
	}


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

	public boolean isValid() {
		if (this.catalogue.size() != 4) {
			return false;
		} else {
			Boolean[] tabOfCategories = new Boolean[4];
			for(int i=0; i<tabOfCategories.length; i++) {
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
					//System.out.println(tabOfCategories[2] == true);
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

	public Collection<PartType> getMyParts() {
		Collection<PartType> res;
		res = catalogue.values();
		return res;

	}

	public PartType ShowMyPartFromCategory(Category cat) {
		if (catalogue.containsKey(cat)) {
			return catalogue.get(cat);
		}
		return null;
	}

	@Override
	public String toString() {
		return catalogue +"";
	}
}