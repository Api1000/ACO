package Interfaces;

import java.util.ArrayList;

import model.Catalogue;
import model.PartName;

public interface IncompatibilityManager {

	public ArrayList<Part> getIncompatibilities();
	
	public ArrayList<Part> getRequirements();
	
	public boolean addRequirement(ArrayList<Part> requirement);
	
	public boolean addIncompatibility(ArrayList<Part> incompatibility);
}
