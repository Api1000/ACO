package Test;


import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Impl.IncompatibilityManagerImpl;
import Impl.PartImpl;
import model.Catalogue;
import model.PartDescription;
import model.PartName;

class Testaco {

	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/

	Catalogue catalogue = new Catalogue();
	
	@Test
	public void testPartImpl() {
	ConfigImpl config1 = new ConfigImpl();
	System.out.println("1");
	PartImpl part1 = new PartImpl(new CategoryImpl("EG100"),new PartName("Gasoline, 100 kW"),new PartDescription("Engine"),new IncompatibilityManagerImpl());
	System.out.println("1");
	PartImpl part2 = new PartImpl(new CategoryImpl("TM5"),new PartName("Gasoline, 100 kW"),new PartDescription("Engine"),new IncompatibilityManagerImpl());
	System.out.println("1");
	config1.addPart(part1.name.partName);
	config1.addPart(part2.name);
	//System.out.println("coin");
	System.out.println("coucou");
	System.out.println(config1.toString());
	//config1.showconfiguration();
	assertTrue(true);
	}


	/*@Test
	public void Testshowpart() {
		CategoryImpl Engine = new CategoryImpl();
		CategoryImpl Transmission = new CategoryImpl();
		CategoryImpl Exterior = new CategoryImpl();
		CategoryImpl Interior = new CategoryImpl();
		
		
	}*/

	/*@Test
	public void testaddpart() {
		assertFalse(config1.addpart(part1));
	}*/
/*
	@Test
	public void testremovepart() {
		config1.addpart(part1);
		assertFalse(config1.removepart(part1));
	}*/
}
