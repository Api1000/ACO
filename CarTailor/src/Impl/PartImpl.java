package Impl;

import Interfaces.IncompatibilityManager;
import Interfaces.Part;
import Interfaces.PartType;
import model.PartDescription;
import model.PartName;

public class PartImpl implements Part{
	
	public CategoryImpl category;
	public PartName name;
	public PartDescription description;
	public IncompatibilityManager im;
	
	public PartImpl() {
		this.category = new CategoryImpl();
		this.name = new PartName();
		this.description = new PartDescription();
		this.im = new IncompatibilityManagerImpl();
	}
	
	public PartImpl(CategoryImpl Category, PartName Name, PartDescription Description, IncompatibilityManagerImpl ir) {
		this.category = Category;
		this.name = Name;
		this.description = Description;
		
	}
	

}
