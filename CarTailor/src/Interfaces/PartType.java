package Interfaces;

import model.PartDescription;
import model.PartName;

public interface PartType {

	public Category getCategory();

	public PartName getName();

	public PartDescription getDescription();

	public String toString();

}
