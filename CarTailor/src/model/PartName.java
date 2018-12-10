package model;

public class PartName {
	
	public String partName;
	
	
	public PartName(String name) {
		this.partName = name;
	}
	
	public String getName() {
		return this.partName;
	}

	@Override
	public String toString() {
		return partName;
	}
	
	
}
