package Interfaces;

import java.util.ArrayList;

import model.Catalogue;
import model.PartName;
import Interfaces.PartType;

public interface IncompatibilityManager {

	public ArrayList<PartType> getIncompatibilities();
	
	public ArrayList<PartType> getRequirements();
	
	public boolean addRequirement(ArrayList<PartType> requirement);
	
	public boolean removeRequirement(ArrayList<PartType> requirement);
	
	public boolean addIncompatibility(ArrayList<PartType> incompatibility);
	
	public boolean removeIncompatibility(ArrayList<PartType> incompatibility);
}
