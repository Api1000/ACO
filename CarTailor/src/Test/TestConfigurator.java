package Test;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Impl.ConfiguratorImpl;
import Impl.PartTypeImpl;
import Interfaces.Category;
import Interfaces.Configurator;
import Interfaces.PartType;
import model.Catalogue;

public class TestConfigurator {

	// The constructor of ConfiguratorImpl use InitConfigurator();

	private int count = 0;
	private Catalogue cat = new Catalogue();
	private Configurator configurator = new ConfiguratorImpl();
	private Category Engine = new CategoryImpl("Engine");
	private Category Transmission = new CategoryImpl("Transmission");
	private Category Exterior = new CategoryImpl("Exterior");
	private Category Interior = new CategoryImpl("Interior");

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
		assertTrue(count == 4);
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
		assertTrue(count == 6);
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
		assertTrue(count == 6);
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
		assertTrue(count == 3);
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
		assertTrue(count == 3);
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
	 * @return true : Can remove a part from the config
	 */
	@Test
	public void TestRemovePart() {
		assertTrue(configurator.addPart(cat.partengine1));
		System.out.println(configurator.toString());
		assertTrue(configurator.removePart(cat.partengine1));

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
	 * can not show the Part from the category c if c is not in the config
	 */
	@Test
	public void testGetMyPartFromCategory1() {

	}

	/*
	 * show properly the part from the category c in the config
	 */
	@Test
	public void testGetMyPartFromCategory2() {

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
		ConfigImpl config = new ConfigImpl(cat.cataconfig); // On ajoute le map cr�er dans une config
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
