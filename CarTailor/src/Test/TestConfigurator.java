package Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Impl.ConfiguratorImpl;
import Interfaces.Category;
import Interfaces.Configurator;
import Interfaces.PartType;
import model.Catalogue;

/**
 * Test class of the configurator
 * 
 * @author Romain
 *
 */
public class TestConfigurator {

	// The constructor of ConfiguratorImpl use InitConfigurator();

	private int count = 0;
	private Catalogue cat = new Catalogue();
	private Configurator configurator = new ConfiguratorImpl();
	private Category Engine = new CategoryImpl("Engine");
	private Category Interior = new CategoryImpl("Interior");
	private Category Test = new CategoryImpl("Test");
	private LinkedHashSet<PartType> Interiors = new LinkedHashSet<>();
	private LinkedHashSet<Set<PartType>> Interiors2 = new LinkedHashSet<>();

	

	/*
	 * Initalizing Test of the configurator
	 * 
	 * The configurator contains only the four Category (Engine, Transmission,
	 * Exterior, Interior)
	 */
	@Test
	public void TestInitConfigurator() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.parttrans1.getCategory(), cat.parttrans1);
		cat.cataconfig.put(cat.partext1.getCategory(), cat.partext1);
		cat.cataconfig.put(cat.partint1.getCategory(), cat.partint1);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		Collection<Category> coll = cat.cataconfig.keySet();
		for (@SuppressWarnings("unused")
		Category c : coll) {
			count++;
		}
		System.out.println(configurator.toString());
		assertEquals(count, 4);
		assertTrue(coll.containsAll(cat.cataconfig.keySet()));
	}

	/*
	 * Initalizing Test of the configurator
	 * 
	 * The configurator contains all the PartType available in the category Engine
	 */
	@Test
	public void TestInitEngine() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.partengine2.getCategory(), cat.partengine2);
		cat.cataconfig.put(cat.partengine3.getCategory(), cat.partengine3);
		cat.cataconfig.put(cat.partengine4.getCategory(), cat.partengine4);
		cat.cataconfig.put(cat.partengine5.getCategory(), cat.partengine5);
		cat.cataconfig.put(cat.partengine6.getCategory(), cat.partengine6);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		Collection<Category> coll = cat.cataconfig.keySet();
		for (@SuppressWarnings("unused")
		Category c : coll) {
			count++;
		}
		assertEquals(count, 6);
		assertTrue(coll.containsAll(cat.cataconfig.keySet()));
	}

	/*
	 * Initalizing Test of the configurator
	 * 
	 * The configurator contains all the PartType available in the category
	 * Transmission
	 */
	@Test
	public void TestInitTransmission() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.partengine2.getCategory(), cat.partengine2);
		cat.cataconfig.put(cat.partengine3.getCategory(), cat.partengine3);
		cat.cataconfig.put(cat.partengine4.getCategory(), cat.partengine4);
		cat.cataconfig.put(cat.partengine5.getCategory(), cat.partengine5);
		cat.cataconfig.put(cat.partengine6.getCategory(), cat.partengine6);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		Collection<Category> coll = cat.cataconfig.keySet();
		for (@SuppressWarnings("unused")
		Category c : coll) {
			count++;
		}
		assertEquals(count, 6);
		assertTrue(coll.containsAll(cat.cataconfig.keySet()));
	}

	/*
	 * Initalizing Test of the configurator
	 * 
	 * The configurator contains all the PartType available in the category Exterior
	 */
	@Test
	public void TestInitExterior() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.partengine2.getCategory(), cat.partengine2);
		cat.cataconfig.put(cat.partengine3.getCategory(), cat.partengine3);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		Collection<Category> coll = cat.cataconfig.keySet();
		for (@SuppressWarnings("unused")
		Category c : coll) {
			count++;
		}
		assertEquals(count, 3);
		assertTrue(coll.containsAll(cat.cataconfig.keySet()));
	}
	/*
	 * Initalizing Test of the configurator
	 * 
	 * The configurator contains all the PartType available in the category Interior
	 */

	@Test
	public void TestInitInterior() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.partengine2.getCategory(), cat.partengine2);
		cat.cataconfig.put(cat.partengine3.getCategory(), cat.partengine3);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		Collection<Category> coll = cat.cataconfig.keySet();
		for (@SuppressWarnings("unused")
		Category c : coll) {
			count++;
		}
		assertEquals(count, 3);
		assertTrue(coll.containsAll(cat.cataconfig.keySet()));
	}

	/*
	 * Test AddPart method
	 * 
	 * @return true : Can add a part in the config
	 */
	@Test
	public void TestAddPart() {
		assertTrue(configurator.addPart(cat.partengine1));
	}

	/*
	 * Test AddPart method
	 * 
	 * @return false : Can't add twice a same part in the config
	 */
	@Test
	public void TestAddNotSamePart() {
		assertTrue(configurator.addPart(cat.partengine1));
		assertFalse(configurator.addPart(cat.partengine1));
	}

	/*
	 * Test RemovePart method
	 * 
	 * @return true : Can remove a part from the config of the configurator
	 */
	@Test
	public void TestRemovePart() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		assertTrue(config.RemovePart(cat.partengine1));
	}

	/*
	 * Test RemovePart method
	 * 
	 * @return false : Can't remove a part from the config if it doesn't exist
	 * before
	 */
	@Test
	public void TestRemoveNotPart() {
		assertFalse(configurator.removePart(cat.partengine1));
	}

	/*
	 * Test GetMyPartFromCategory method
	 * 
	 * Show the part from the category in the config
	 */
	@Test
	public void TestGetMyPartFromCategory() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		assertEquals(configurator.getMyPartFromCategory(Engine), cat.partengine1);
	}

	/*
	 * Test GetMyPartFromCategory method
	 * 
	 * Can't show the Part from the category if it is not in the config
	 * 
	 */
	@Test
	public void TestGetNotMyPartFromCategory() {
		assertEquals(configurator.getMyPartFromCategory(Engine), null);
	}

	/**
	 * Test GetPartFromCategory method
	 * 
	 * Can show parts from a given category of the config
	 */
	@Test
	public void TestGetPartsFromCategory() {
		cat.cataconfig.put(cat.partint1.getCategory(), cat.partint1);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		Interiors.add(cat.partint1);
		Interiors.add(cat.partint2);
		Interiors.add(cat.partint3);
		Interiors.toArray();
		Interiors2.add(configurator.getPartsFromCategory(Interior));
		Object[] tab = configurator.getPartsFromCategory(Interior).toArray();
		assertEquals(Arrays.toString(tab), Interiors.toString()); 
	}
	
	/**
	 * Test GetPartFromCategory method
	 * 
	 * Can't show parts from a given category of the config if this category doesn't exist
	 */
	@Test
	public void TestGetNotPartsFromCategory() {
		assertEquals(configurator.getPartsFromCategory(Test), null);
	}
	
	/*
	 * Test isValid method
	 * 
	 * @return true : Config is valid for the configurator
	 */
	@Test
	public void isValidConfigurator() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.parttrans1.getCategory(), cat.parttrans1);
		cat.cataconfig.put(cat.partext1.getCategory(), cat.partext1);
		cat.cataconfig.put(cat.partint1.getCategory(), cat.partint1);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		assertTrue(configurator.isValid());

	}

	/*
	 * Test isValid method
	 * 
	 * @return false : Config is invalid for the configurator because it's empty
	 */
	@Test
	public void isInvalidConfigurator() {
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		assertFalse(configurator.isValid());
	}

	/*
	 * Test isValid method
	 * 
	 * @return false : Config is invalid for the configurator because one part is
	 * missing
	 */
	@Test
	public void isInvalidConfiguratorMiss1() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.parttrans1.getCategory(), cat.parttrans1);
		cat.cataconfig.put(cat.partint1.getCategory(), cat.partint1);
		ConfigImpl config = new ConfigImpl(cat.cataconfig); // On ajoute le map créer dans une config
		configurator.setConfig(config); // On met cette config dans le configurator
		assertFalse(configurator.isValid()); // On test si le configurator est valide
	}

	/*
	 * Test isValid method
	 * 
	 * @return false : Config is invalid for the configurator because 2 parts of the
	 * same Category are added
	 */
	@Test
	public void isInvalidConfiguratorSameCategory() {
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.parttrans1.getCategory(), cat.parttrans1);
		cat.cataconfig.put(cat.partext1.getCategory(), cat.partext1);
		cat.cataconfig.put(cat.partext1.getCategory(), cat.partext1);
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		assertFalse(configurator.isValid());
	}

}
