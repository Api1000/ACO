package Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Impl.IncompatibilityManagerImpl;
import Impl.PartTypeImpl;
import Interfaces.Category;
import Interfaces.Configuration;
import Interfaces.PartType;
import model.Catalogue;
import model.PartDescription;
import model.PartName;

/**
 * Tests of the ConfigImpl class
 * 
 * @author Romiche
 *
 */
public class TestConfiguration {

	private Configuration config1 = new ConfigImpl();
	private Catalogue fromcatalogue = new Catalogue();
	private Map<Category, PartType> catalogue = new HashMap<>();
	private Collection<PartType> Parts = new HashSet<>();

	/**
	 * PartTypes from the catalog.
	 */
	private PartType partype1 = fromcatalogue.partengine1;
	private PartType partype2 = fromcatalogue.partengine2;
	private PartType partype3 = fromcatalogue.parttrans1;
	private PartType partype4 = fromcatalogue.partext1;
	private PartType partype5 = fromcatalogue.partint1;

	/*
	 * @Test public void init() { catalogue.initialize(); }
	 */

	/*
	 * Test of AddPart method
	 * 
	 * @return true : Can add a part to the configuration
	 */
	@Test
	public void TestAddPart() {
		assertTrue(config1.AddPart(partype1));
	}

	/*
	 * Test of AddPart method
	 * 
	 * @return false : Can't add twice a part to the configuration
	 */
	@Test
	public void TestAddNotSamePart() {
		assertTrue(config1.AddPart(partype2));
		assertFalse(config1.AddPart(partype2));
	}

	/**
	 * Test of RemovePart method
	 * 
	 * @return true : Can remove a part to the configuration after adding it
	 */
	@Test
	public void TestRemovePart() {
		assertTrue(config1.AddPart(partype1));
		assertTrue(config1.RemovePart(partype1));
	}

	/**
	 * Test of RemovePart method
	 * 
	 * @return false : Can't remove a part to the configuration if it doesn't exist
	 *         in.
	 */
	@Test
	public void TestRemoveNotPart() {
		assertFalse(config1.RemovePart(partype2));
	}

	/**
	 * Test of isValid method
	 * 
	 * @return true if the configuration contains a Part of each Category
	 */
	@Test
	public void isValidConfig() {
		catalogue.put(partype1.getCategory(), partype1); // On ajoute les PartType(value) et leur category(key) dans une
															// Map
		catalogue.put(partype3.getCategory(), partype3);
		catalogue.put(partype4.getCategory(), partype4);
		catalogue.put(partype5.getCategory(), partype5);
		Configuration config = new ConfigImpl(catalogue); // On ajoute le Map créé dans une config
		assertTrue(config.isValid()); // On test si la config est valide
	}

	/*
	 * Test of isValid method
	 * 
	 * @return false if the configuration contains only three or less Parts
	 */
	@Test
	public void isInValidConfig() {
		catalogue.put(partype1.getCategory(), partype1);
		catalogue.put(partype3.getCategory(), partype3);
		Configuration config = new ConfigImpl(catalogue);
		assertFalse(config.isValid());
	}

	/**
	 * Test of isValid method
	 * 
	 * @return false if the configuration contains twice a same part
	 */
	@Test
	public void isInValidConfigSamePart() {
		catalogue.put(partype1.getCategory(), partype1);
		catalogue.put(partype3.getCategory(), partype3);
		catalogue.put(partype4.getCategory(), partype4);
		catalogue.put(partype4.getCategory(), partype4);
		Configuration config = new ConfigImpl(catalogue);
		assertFalse(config.isValid());
	}

	/**
	 * Test of isValid method
	 * 
	 * @return false if the configuration doesn't contains a Part
	 */
	@Test
	public void isInValidConfigWithoutParts() {
		assertFalse(config1.isValid());
	}

	/**
	 * Test of getMyParts method
	 * 
	 * @return true : Can show parts in the configuration
	 */
	@Test
	public void TestGetMyParts() {
		catalogue.put(partype1.getCategory(), partype1);
		Configuration config = new ConfigImpl(catalogue);
		Parts.add(partype1);
		assertTrue(config.getMyParts().containsAll(Parts));
	}

	/**
	 * Test of getMyParts method
	 * 
	 * @return false : Can't show parts in the configuration
	 */
	@Test
	public void TestCannotGetMyParts() {
		catalogue.put(partype1.getCategory(), partype1);
		Configuration config = new ConfigImpl(catalogue);
		assertFalse(config.getMyParts().equals(Parts));
	}

	/**
	 * Test of ShowMyPartFromCategory method
	 * 
	 * @return true : Can show a part from a category
	 */
	@Test
	public void TestShowMyPartFromCategory1() {
		catalogue.put(partype1.getCategory(), partype1);
		Configuration config = new ConfigImpl(catalogue);
		assertTrue(config.ShowMyPartFromCategory(partype1.getCategory()).equals(partype1));
	}

	/**
	 * Test of ShowMyPartFromCategory method
	 * 
	 * @return false : Can't show a part if his category not added in the config
	 */
	@Test
	public void TestShowMyPartFromCategory2() {
		CategoryImpl cat = new CategoryImpl("Not");
		try {
			config1.ShowMyPartFromCategory(cat);
		} catch (AssertionError e) {
			assertEquals("java.lang.AssertionError: This category does not exist", e.toString());
		}
	}

}
