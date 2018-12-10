package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Interfaces.Category;
import Interfaces.Configuration;
import Interfaces.PartType;
import model.Catalogue;

/**
 * Tests of Category class
 * @author Romiche
 *
 */
public class TestCategory {

	private Category category = new CategoryImpl("Engine");
	private Category category2 = new CategoryImpl("Exterior");
	private Catalogue catalogue = new Catalogue();

	private PartType partype1 = catalogue.partengine1;
	private PartType partype2 = catalogue.parttrans1;
	private PartType partype3 = catalogue.partext1;
	//private PartType partype4 = catalogue.partint1;

	/**
	 * Test of addPartInCategory method
	 * @return true : Can add a Part in his own category
	 */
	@Test
	public void TestAddInCategory() {
		assertTrue(category.addPartInCategory(partype1));
	}

	/**
	 * Test of addPartInCategory method
	 * @return false : Can't add a part of another category in the current category
	 */
	@Test
	public void TestAddNotInCategory() {
		assertFalse(category.addPartInCategory(partype2));
	}
	
	/**
	 * Test of addPartInCategory method
	 * @return false : Can't add twice a part in the same category
	 */
	@Test
	public void TestAddNotSameInCategory() {
		assertTrue(category.addPartInCategory(partype1));
		assertFalse(category.addPartInCategory(partype1));
	}

	/**
	 * Test of removePartInCategory method
	 * @return true : Can remove a Part from a category
	 */
	@Test
	public void TestRemoveInCategory() {
		assertTrue(category2.addPartInCategory(partype3));
		assertTrue(category2.removePartInCategory(partype3));
	}

	/**
	 * Test of removePartInCategory method
	 * @return false : Can't remove a Part from a category if it doesn't exist in
	 */
	@Test
	public void TestRemoveNotInCategory() {
		assertFalse(category2.removePartInCategory(partype3));
	}
	
	/**
	 * Test of removePartInCategory method
	 * @return false : Can't remove a Part from a category if it doesn't exist in
	 */
	@Test
	public void TestRemoveNotInCategory2() {
		assertFalse(category2.removePartInCategory(partype2));
	}
	
}
