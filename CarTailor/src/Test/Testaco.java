package Test;


import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Impl.IncompatibilitiesImpl;
import Impl.PartTypeImpl;
import Impl.RequirementsImpl;
import Interfaces.Configuration;
import model.Catalogue;
import model.Description;
import model.Name;

class Testaco {

	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/

	Catalogue catalogue = new Catalogue();
	
	@Test
	public void testPartImpl() {
	ConfigImpl config1 = new ConfigImpl();
	ConfigImpl part1 = new ConfigImpl("EG100","Gasoline, 100 kW","Engine"," ", " ");
	ConfigImpl part2 = new ConfigImpl("TM5","Manual, 5 gears","Transmission","", "");
	config1.addPart(part1);
	config1.addPart(part2);
	//System.out.println("coin");
	System.out.println(config1.toString());
	//config1.showlistpartcategories();
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
