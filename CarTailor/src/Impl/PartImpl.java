package Impl;

import Interfaces.Part;
import Interfaces.PartType;
import model.PartDescription;
import model.PartName;

public class PartImpl implements Part{
	
	public CategoryImpl category;
	public PartName name;
	public PartDescription description;
	public String incompatibilities;
	public String requirements;
	
	public PartImpl() {
		this.category = new String();
		this.name = new String();
		this.description = new String();
		this.incompatibilities = new String();
		this.requirements = new String();
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
