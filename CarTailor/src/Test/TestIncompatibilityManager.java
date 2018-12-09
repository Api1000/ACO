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

	private Catalogue cat = new Catalogue();
	private ConfigImpl config1 = new ConfigImpl();
	private IncompatibilityManagerImpl configIR = new IncompatibilityManagerImpl(config1);

	/**
	 * Test of addIncompatiblity method
	 * 
	 * @return true : Can add an incompatibility between 2 parts
	 */
	@Test
	public void addIncompatibilities1() {
		assertTrue(configIR.addIncompatibility(cat.parttrans3, cat.partengine1));
	}

	/**
	 * Test of addIncompatiblity method
	 * 
	 * @return false : Can't add twice an incompatibility between 2 parts
	 */
	@Test
	public void addIncompatibilities2() {
		assertTrue(configIR.addIncompatibility(cat.parttrans3, cat.partengine1));
		assertFalse(configIR.addIncompatibility(cat.parttrans3, cat.partengine1));
	}

	/**
	 * Test of addRequirement method
	 * 
	 * @return true : Can add a requirement between 2 parts
	 */
	@Test
	public void addRequirement1() {
		assertTrue(configIR.addRequirement(cat.partengine6, cat.parttrans6));
	}

	/**
	 * Test of addRequirement method
	 * 
	 * @return false : Can't add twice a requirement between 2 parts
	 */
	@Test
	public void addRequirement2() {
		assertTrue(configIR.addRequirement(cat.partengine6, cat.parttrans6));
		assertFalse(configIR.addRequirement(cat.partengine6, cat.parttrans6));

	}

	/**
	 * Test of removeIncompatibility method
	 * 
	 * @return true : Can remove an incompatibility between 2 parts
	 */
	@Test
	public void removeIncompatibilities1() {
		assertTrue(configIR.addIncompatibility(cat.partext1, cat.partengine3));
		assertTrue(configIR.removeIncompatibility(cat.partext1, cat.partengine3));
	}

	/**
	 * Test of removeIncompatibility method
	 * 
	 * @return false : Can't remove an incompatibility between 2 parts if doesn't
	 *         exist before
	 */
	@Test
	public void removeIncompatibilities2() {
		assertFalse(configIR.removeIncompatibility(cat.partext1, cat.partengine3));
	}

	/**
	 * Test of removeRequirement method
	 * 
	 * @return true : Can remove a requirement between 2 parts
	 */
	@Test
	public void removeRequirements1() {
		assertTrue(configIR.addRequirement(cat.partext1, cat.partengine3));
		assertTrue(configIR.removeRequirement(cat.partext1, cat.partengine3));
	}

	/**
	 * Test of removeIncompatibility method
	 * 
	 * @return false : Can't remove a requirement between 2 parts if doesn't exist
	 *         before
	 */
	@Test
	public void removeRequirements2() {
		assertFalse(configIR.removeRequirement(cat.partext1, cat.partengine3));
	}

	/**
	 * Test of isCompatible method
	 * 
	 * @return true :
	 */
	@Test
	public void isValid1() {
		assertTrue(configIR.addRequirement(cat.partext3, cat.partint3));
		assertTrue(configIR.isCompatible());
	}

	/**
	 * Test of isCompatible method
	 * 
	 * @return false :
	 */
	@Test
	public void isInValid() {
		assertFalse(configIR.isCompatible());
	}
}
