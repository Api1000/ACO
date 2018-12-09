package Impl;


import Interfaces.Category;
import Interfaces.PartType;
import model.PartDescription;
import model.PartName;

public class PartTypeImpl implements PartType {

	private Category category;
	private PartName name;
	private PartDescription description;

	public PartTypeImpl() {
		this.category = new CategoryImpl();
		this.name = new PartName();
		this.description = new PartDescription();
	}

	public PartTypeImpl(Category category, PartName name, PartDescription description) {
		this.category = category;
		this.name = name;
		this.description = description;
	}
	public PartTypeImpl(PartName name, PartDescription description) {
		this.name = name;
		this.description = description;
	}


	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public PartName getName() {
		return name;
	}

	public void setName(PartName name) {
		this.name = name;
	}

	public PartDescription getDescription() {
		return description;
	}

	public void setDescription(PartDescription description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\n    |" + name + ", " + description + "|";
	}

}
