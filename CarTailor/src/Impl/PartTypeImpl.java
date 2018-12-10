package Impl;

import Interfaces.Category;
import Interfaces.PartType;
import model.PartDescription;
import model.PartName;

public class PartTypeImpl implements PartType {

	private Category category;
	private PartName name;
	private PartDescription description;

	public PartTypeImpl(Category category, PartName name, PartDescription description) {
		this.category = category;
		this.name = name;
		this.description = description;
	}

	public Category getCategory() {
		return this.category;
	}

	public PartName getName() {
		return name;
	}

	public PartDescription getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "\n    |" + name + ", " + description + "|";
	}

}
