package model;

public class PartDescription {
	public String description;
	
	public PartDescription(String desc) {
		this.description = desc;
	}
	
	public String getDescription() {
		return this.description;
	}

	@Override
	public String toString() {
		return  description;
	}
	
	
}
