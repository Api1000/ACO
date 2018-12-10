package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Test;

import Impl.ConfigImpl;
import Impl.ConfiguratorImpl;
import Impl.IncompatibilityManagerImpl;
import Interfaces.Category;
import Interfaces.Configurator;
import Interfaces.PartType;
import model.Catalogue;
import model.PartDescription;
import model.PartName;

/**
 * Test class of getters and setters to coverage codes
 * @author Romain
 *
 */
public class TestGetSet {

	private Catalogue cat = new Catalogue();
	private ConfigImpl config = new ConfigImpl();
	private Configurator configurator = new ConfiguratorImpl();
	private IncompatibilityManagerImpl configIR = new IncompatibilityManagerImpl(config);
	private Map<PartType, ArrayList<PartType>> incompatibilities = new HashMap<>();
	private Map<PartType, ArrayList<PartType>> requirements = new HashMap<>();
	private ArrayList<PartType> setincomp = new ArrayList<>();
	private ArrayList<PartType> setrequire = new ArrayList<>();
	private PartName name = new PartName("EG100");
	private PartDescription description = new PartDescription("EG100");

	/**
	 * @return name of a PartName
	 */
	@Test
	public void TestGetName() {
		assertEquals(cat.partengine1.getName().toString(), "EG100");
		assertEquals(name.getName(), "EG100");
	}
	
	/**
	 * @return description of a PartDescription
	 */
	@Test
	public void TestGetDescription() {
		assertEquals(cat.partengine1.getDescription().toString(), "Gasoline, 100 kW");
		assertEquals(description.getDescription(), "EG100");

	}
	
	/**
	 * Test of getIncompatibilities and getRequirements from IncompatibilityManager
	 */
	@Test
	public void TestGetInIncompRequManager() {
		configIR.addIncompatibility(cat.parttrans3, cat.partengine1);
		configIR.addRequirement(cat.partext3, cat.partint3);
		setincomp.add(cat.partengine1);
		setrequire.add(cat.partint3);
		incompatibilities.put(cat.parttrans3, setincomp);
		requirements.put(cat.partext3, setrequire);
		assertEquals(configIR.getIncompatibilities(),incompatibilities);
		assertEquals(configIR.getRequirements(),requirements);
	}
	
	/**
	 * Test of getConfig and getCategory from the configurator
	 */
	@Test
	public void TestGetInConfigurator() {
		configurator.newConfig();
		Collection<Category> coll = new HashSet<>();
		coll.add(cat.partengine1.getCategory());
		coll.add(cat.parttrans1.getCategory());
		coll.add(cat.partext1.getCategory());
		System.out.println(coll);
		System.out.println(configurator.getCategory());
		assertEquals(configurator.getConfig().toString(),"{}");
		//assertEquals(configurator.getCategory().toString(), coll);
	}
}
