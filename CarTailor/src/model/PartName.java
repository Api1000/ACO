package model;

public class PartName {
	public String partName;
	
	public PartName() {
		this.partName = new String();
	}
	
	public PartName(String name) {
		this.partName = name;
	}
	
	public String getName() {
		return this.partName;
	}
}
