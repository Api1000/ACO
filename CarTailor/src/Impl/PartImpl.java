package Impl;

import Interfaces.Part;
import model.PartDescription;
import model.PartName;

public class PartImpl implements Part{
	
	public CategoryImpl category;
	public PartName name;
	public PartDescription description;
	public IncompatibilityManagerImpl im;
	
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
	


}
