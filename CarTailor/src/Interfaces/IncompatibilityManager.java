package Interfaces;

import java.util.Set;

import model.Catalogue;
import model.PartName;
import Interfaces.PartType;

public interface IncompatibilityManager {

	public Set<PartType> getIncompatibilities();
	
	public Set<PartType> getRequirements();
	
	public boolean addRequirement(Set<PartType> requirement);
	
	public boolean removeRequirement(Set<PartType> requirement);
	
	public boolean addIncompatibility(Set<PartType> incompatibility);
	
	public boolean removeIncompatibility(Set<PartType> incompatibility);
}
