package Interfaces;

import model.PartDescription;
import model.PartName;


public interface PartType
{

	public Category getCategory();

	public void setCategory(Category category);

	public PartName getName();

	public void setName(PartName name);

	public PartDescription getDescription();

	public void setDescription(PartDescription description);
	
	public String toString();
	
	
}

