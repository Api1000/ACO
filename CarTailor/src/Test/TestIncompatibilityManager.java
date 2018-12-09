package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import Impl.ConfigImpl;
import Impl.IncompatibilityManagerImpl;
import Interfaces.PartType;
import model.Catalogue;

public class TestIncompatibilityManager {

	
	private ConfigImpl config1 = new ConfigImpl();
	private HashMap<PartType, ArrayList<PartType>> incompatibilities;
	private HashMap<PartType, ArrayList<PartType>> requirements;
	private IncompatibilityManagerImpl configIR = new IncompatibilityManagerImpl(incompatibilities, requirements, config1);
	
	private Catalogue fromcatalogue = new Catalogue();
	
	@Test
	public void addIncompatibilities() {
		configIR.addIncompatibility(fromcatalogue.parttrans3, fromcatalogue.partengine1);
		System.out.println(configIR.toString());
	}

	@Test
	public void addRequirement() {

	}

	@Test
	public void removeIncompatibilities() {

	}

	@Test
	public void removeRequirements() {

	}
}
