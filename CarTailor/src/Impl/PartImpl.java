package Impl;

import Interfaces.Part;
import Interfaces.PartType;
import model.PartDescription;
import model.PartName;
import Interfaces.IncompatibilityManager;
import Interfaces.Category;

public class PartImpl implements PartType{
	
	public Category category;
	public PartName name;
	public PartDescription description;
	public IncompatibilityManager im;
	
	public PartImpl() {
		this.category = new CategoryImpl();
		this.name = new PartName();
		this.description = new PartDescription();
		this.im = new IncompatibilityManagerImpl();
	}
	
	public PartImpl(CategoryImpl category,PartName name,PartDescription description) {
		this.category = category;
		this.name = name;
		this.description = description;
	}


	
	public PartImpl(CategoryImpl category,PartName name,PartDescription description,IncompatibilityManagerImpl im) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.im = im;
	}

	
	
	public Category getCategory() {
		return category;
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

	public IncompatibilityManager getIm() {
		return im;
	}

	public void setIm(IncompatibilityManager im) {
		this.im = im;
	}

	@Override
	public String toString() {
		return "category=" + category + ", name=" + name + ", description=" + description + ", im=" + im
				;
	}
	
	


}
