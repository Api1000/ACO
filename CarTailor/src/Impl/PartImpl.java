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
	
	public PartImpl(String part) {
		this.part = part;
	}
	
	public boolean addpart(String part) {
		return true;
	}
	
	
	public boolean removepart(String part) {
		// TODO Auto-generated method stub
		return false;
	}
}
