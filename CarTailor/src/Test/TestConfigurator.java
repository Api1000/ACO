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

	private Catalogue cat = new Catalogue();
	private Configurator configurator = new ConfiguratorImpl();
	private Category Engine = new CategoryImpl("Engine");
	private Category Transmission = new CategoryImpl("Transmission");
	private Category Exterior = new CategoryImpl("Exterior");
	private Category Interior = new CategoryImpl("Interior");

	/*
	 * The configurator contains only the four Category (Engine, Transmission,
	 * Exterior, Interior)
	 */

	@Test
	public void testInit1() {

		Collection<Category> toCompare = new HashSet<>();
		toCompare.add(Transmission);
		toCompare.add(Interior);
		toCompare.add(Exterior);
		toCompare.add(Engine);

		Collection<Category> myCat = configurator.getCategory();

		Collection<String> toCompareString = new HashSet<>();
		for (Category c : toCompare) {
			toCompareString.add(c.getCategoryString());
		}

		Collection<String> myCatString = new HashSet<>();
		for (Category c : myCat) {
			myCatString.add(c.getCategoryString());
		}
		assertTrue(myCat.size() == 4);
		assertEquals(myCatString.containsAll(toCompareString), toCompareString.containsAll(myCatString));
	}

	/*
	 * The configurator contains all the PartType available in the category Engine
	 */

	@Test
	public void testInit2() {

		Engine.addCategory(cat.partengine1);
		Engine.addCategory(cat.partengine2);
		Engine.addCategory(cat.partengine3);
		Engine.addCategory(cat.partengine4);
		Engine.addCategory(cat.partengine5);
		Engine.addCategory(cat.partengine6);

		Collection<Category> myCategories = configurator.getCategory();
		//System.out.println(configurator.toString());
		String Eng = "Engine";
		Set<PartType> setP = new HashSet<>();
		for (Category c : myCategories) {
			if (c.getCategoryString() == Eng) {
				setP = c.getPartImpl();
				break;
			}
		}
		Set<String> setPToString = new HashSet<>();
		for (PartType p : setP) {
			setPToString.add(p.getName().partName);
		}
		Collection<PartType> toCompare = Engine.getPartImpl();
		Set<String> toCompareWith = new HashSet<>();
		for (PartType p : toCompare) {
			toCompareWith.add(p.getName().partName);
		}
		// System.out.println(Engine.toString());
		assertTrue(toCompareWith.size() == 6);
		assertEquals(toCompareWith.containsAll(setPToString), setPToString.containsAll(toCompareWith));
	}

	/*
	 * The configurator contains all the PartType available in the category
	 * Transmission
	 */

	@Test
	public void testInit3() {

		Transmission.addCategory(cat.parttrans1);
		Transmission.addCategory(cat.parttrans2);
		Transmission.addCategory(cat.parttrans3);
		Transmission.addCategory(cat.parttrans4);
		Transmission.addCategory(cat.parttrans5);
		Transmission.addCategory(cat.parttrans6);

		Collection<Category> myCategories = configurator.getCategory();
		String Trans = "Transmission";
		Set<PartType> setP = new HashSet<>();
		for (Category c : myCategories) {
			if (c.getCategoryString() == Trans) {
				setP = c.getPartImpl();
				break;
			}
		}
		Set<String> setPToString = new HashSet<>();
		for (PartType p : setP) {
			setPToString.add(p.getName().partName);
		}
		Collection<PartType> toCompare = Transmission.getPartImpl();
		Set<String> toCompareWith = new HashSet<>();
		for (PartType p : toCompare) {
			toCompareWith.add(p.getName().partName);
		}

		assertTrue(toCompareWith.size() == 6);
		assertEquals(toCompareWith.containsAll(setPToString), setPToString.containsAll(toCompareWith));
	}

	/*
	 * The configurator contains all the PartType available in the category Exterior
	 */

	@Test
	public void testInit4() {

		Exterior.addCategory(cat.partext1);
		Exterior.addCategory(cat.partext2);
		Exterior.addCategory(cat.partext3);

		Collection<Category> myCategories = configurator.getCategory();
		String Ext = "Exterior";
		Set<PartType> setP = new HashSet<>();
		for (Category c : myCategories) {
			if (c.getCategoryString() == Ext) {
				setP = c.getPartImpl();
				break;
			}
		}
		Set<String> setPToString = new HashSet<>();
		for (PartType p : setP) {
			setPToString.add(p.getName().partName);
		}
		Collection<PartType> toCompare = Exterior.getPartImpl();
		Set<String> toCompareWith = new HashSet<>();
		for (PartType p : toCompare) {
			toCompareWith.add(p.getName().partName);
		}

		assertTrue(toCompareWith.size() == 3);
		assertEquals(toCompareWith.containsAll(setPToString), setPToString.containsAll(toCompareWith));
	}

	/*
	 * The configurator contains all the PartType available in the category Interior
	 */

	@Test
	public void testInit5() {

		Interior.addCategory(cat.partint1);
		Interior.addCategory(cat.partint2);
		Interior.addCategory(cat.partint3);

		Collection<Category> myCategories = configurator.getCategory();
		String Int = "Interior";
		Set<PartType> setP = new HashSet<>();
		for (Category c : myCategories) {
			if (c.getCategoryString() == Int) {
				setP = c.getPartImpl();
				break;
			}
		}
		Set<String> setPToString = new HashSet<>();
		for (PartType p : setP) {
			setPToString.add(p.getName().partName);
		}
		Collection<PartType> toCompare = Interior.getPartImpl();
		Set<String> toCompareWith = new HashSet<>();
		for (PartType p : toCompare) {
			toCompareWith.add(p.getName().partName);
		}

		assertTrue(toCompareWith.size() == 3);
		assertEquals(toCompareWith.containsAll(setPToString), setPToString.containsAll(toCompareWith));
	}

	/*
	 * Test AddPart method
	 * 
	 * @return true : Can add a part in the config
	 */
	@Test
	public void testAddPart1() {
		Engine.addCategory(cat.parttrans1);
		assertTrue(configurator.addPart(cat.partengine1));
		//System.out.println(configurator.toString());
	}

	/*
	 * Test AddPart method
	 * 
	 * @return false : Can't add twice a same part in the config
	 */
	@Test
	public void testAddPart2() {
		//Engine.addCategory(cat.partengine1);
		assertTrue(configurator.addPart(cat.partengine1));
		assertFalse(configurator.addPart(cat.partengine1));
		//System.out.println(configurator.toString());
	}

	/*
	 * Test RemovePart method
	 * 
	 * @return true : Can remove a part from the config
	 */
	@Test
	public void testRemovePart1() {
		Engine.addCategory(cat.partengine1);
		/*Map<Category,PartType> catalog = new HashMap<Category, PartType>();
		catalog.put(Engine, cat.partengine1);
		ConfigImpl c = new ConfigImpl(catalog);

		configurator.setConfig(c);
// A revoir ..?
		assertTrue(c.AddPart(cat.partengine1));
		assertTrue(c.RemovePart(cat.partengine1));*/
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
	public void testRemovePart2() {
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
	public void isValid1() {
		Engine.addCategory(cat.partengine1);
		Transmission.addCategory(cat.parttrans1);
		Exterior.addCategory(cat.partext1);
		Interior.addCategory(cat.partint1);
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.parttrans1.getCategory(), cat.parttrans1);
		cat.cataconfig.put(cat.partext1.getCategory(), cat.partext1);
		cat.cataconfig.put(cat.partint1.getCategory(), cat.partint1);
		//System.out.println(cat.cataconfig.toString());
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		assertTrue(configurator.isValid());

	}

	/*
	 * Test isValid method
	 * 
	 * @return false : Config is invalid for the configurator because one part is missing
	 */
	@Test
	public void isInvalid1() {

		Engine.addCategory(cat.partengine1);
		Transmission.addCategory(cat.parttrans1);
		Exterior.addCategory(cat.partext1);
		Interior.addCategory(cat.partint1);
		Interior.addCategory(cat.partint2);
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.parttrans1.getCategory(), cat.parttrans1);
		cat.cataconfig.put(cat.partint1.getCategory(), cat.partint1);
		//System.out.println(cat.cataconfig.toString());
		ConfigImpl config = new ConfigImpl(cat.cataconfig); //On ajoute le map créer dans une config 
		configurator.setConfig(config); // On met cette config dans le configurator
		assertFalse(configurator.isValid()); //On test si le configurator est valide 
	}

	/*
	 * Test isValid method
	 * 
	 * @return false : Config is invalid for the configurator because 2 parts of the same Category are added
	 */
	@Test
	public void isInvalid2() {

		Engine.addCategory(cat.partengine1);
		Transmission.addCategory(cat.parttrans1);
		Exterior.addCategory(cat.partext1);
		Interior.addCategory(cat.partint1);
		cat.cataconfig.put(cat.partengine1.getCategory(), cat.partengine1);
		cat.cataconfig.put(cat.parttrans1.getCategory(), cat.parttrans1);
		cat.cataconfig.put(cat.partext1.getCategory(), cat.partext1);
		cat.cataconfig.put(cat.partext1.getCategory(), cat.partext1);
		//System.out.println(cat.cataconfig.toString());
		ConfigImpl config = new ConfigImpl(cat.cataconfig);
		configurator.setConfig(config);
		assertFalse(configurator.isValid());
	}
}
