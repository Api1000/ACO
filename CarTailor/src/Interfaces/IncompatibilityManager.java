package Interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import model.Catalogue;
import model.PartName;
import Interfaces.PartType;

public interface IncompatibilityManager {

	public HashMap<PartType, ArrayList<PartType>> getIncompatibilities();

	public HashMap<PartType, ArrayList<PartType>> getRequirements();

	public boolean addRequirement(PartType partype, PartType requirement);

	public boolean removeRequirement(PartType partype, PartType requirement);

	public boolean addIncompatibility(PartType partype, PartType incompatibility);

	public boolean removeIncompatibility(PartType partype, PartType incompatibility);

	public boolean isCompatible();
}
