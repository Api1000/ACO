package Test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Impl.IncompatibilityManagerImpl;
import Impl.PartTypeImpl;
import Interfaces.Configuration;
import Interfaces.PartType;
import model.Catalogue;
import model.PartDescription;
import model.PartName;

public class TestConfiguration {

	private Configuration config1 = new ConfigImpl();
	private Catalogue catalogue = new Catalogue();

	private PartType partype1 = catalogue.partengine1;
	private PartType partype2 = catalogue.partengine2;
	private PartType partype3 = catalogue.partengine3;
	private PartType partypenull =  new PartTypeImpl(new CategoryImpl("coin"), new PartName("EG100"), new PartDescription("Gasoline, 100 kW"));


	/*@Test
	public void init() {
		catalogue.initialize();
	}*/

	@Test
	public void TestAddPart1() {
		assertTrue(config1.AddPart(partype1));
		System.out.println(config1.toString());
		
	}

	@Test
	public void TestAddPart2() {
		assertTrue(config1.AddPart(partype2));
		assertFalse(config1.AddPart(partype2));
	}

	@Test
	public void TestAddPart3() {
		catalogue.init();
		assertFalse(config1.AddPart(partypenull));
		//System.out.println(config1.toString());
	}

	@Test
	public void TestRemovePart1() {
		assertTrue(config1.AddPart(partype2));
		assertTrue(config1.RemovePart(partype2));
	}

	@Test
	public void TestRemovePart2() {
		assertFalse(config1.RemovePart(partype3));

	}
}
