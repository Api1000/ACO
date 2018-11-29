package Interfaces;

import java.util.ArrayList;

import model.Catalogue;
import model.PartName;

public interface IncompatibilityManager {

	public ArrayList<PartName> getIncompatibilities();
	
	public ArrayList<PartName> getRequirements();
	
	public boolean addRequirement(ArrayList<PartName> requirement);
	
	public boolean addIncompatibility(ArrayList<PartName> incompatibility);
}
