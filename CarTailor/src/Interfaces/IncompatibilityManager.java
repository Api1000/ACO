package Interfaces;

import java.util.ArrayList;
import java.util.Map;

public interface IncompatibilityManager {

	public Map<PartType, ArrayList<PartType>> getIncompatibilities();

	public Map<PartType, ArrayList<PartType>> getRequirements();

	public boolean addRequirement(PartType partype, PartType requirement);

	public boolean removeRequirement(PartType partype, PartType requirement);

	public boolean addIncompatibility(PartType partype, PartType incompatibility);

	public boolean removeIncompatibility(PartType partype, PartType incompatibility);

	public boolean isCompatible();
}
