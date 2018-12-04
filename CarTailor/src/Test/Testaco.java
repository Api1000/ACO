package Test;


import static org.junit.Assert.*;

import org.junit.Test;
import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Impl.IncompatibilityManagerImpl;
import Impl.PartImpl;
import model.Catalogue;
import model.PartDescription;
import model.PartName;

public class Testaco {

	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/

	//Catalogue catalogue = new Catalogue();
	
	PartImpl part1 = new PartImpl(new CategoryImpl("EG100"), new PartName("Gasoline, 100 kW"),
			new PartDescription("Engine"), new IncompatibilityManagerImpl());
	PartImpl part2 = new PartImpl(new CategoryImpl("TM5"), new PartName("Gasoline, 100 kW"),
			new PartDescription("Engine"), new IncompatibilityManagerImpl());
	
	@Test
	public void testjeanlouis() {
		ConfigImpl config1 = new ConfigImpl();
		System.out.println("1");
		config1.addPart(part1.name);
		// System.out.println("coin");
		System.out.println("coucou");
		System.out.println(config1.toString());
		// config1.showconfiguration();
		//assertTrue(true);
	}
	
	public void testPartImpl() {
	ConfigImpl config1 = new ConfigImpl();
	PartImpl part1 = new PartImpl(new CategoryImpl("Engine"),new PartName("EG100"),new PartDescription("Gasoline, 100 kW"),new IncompatibilityManagerImpl());
	PartImpl part2 = new PartImpl(new CategoryImpl("Engine"),new PartName("ED180"),new PartDescription("Diesel, 180kW"),new IncompatibilityManagerImpl());
	config1.addPart(part1.name);
	config1.addPart(part2.name);
	//System.out.println("coin");
	System.out.println(config1.myConfig.toString());
	//config1.showconfiguration();
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
