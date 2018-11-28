package Test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Impl.PartTypeImpl;
import Impl.Requirements;
import model.Catalogue;
import model.Description;
import model.Incompatibilities;
import model.Name;

class Testaco {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	Catalogue catalogue = new Catalogue();
	

	ConfigImpl config2 = new ConfigImpl();
	ConfigImpl config3 = new ConfigImpl();
	
	@Test
	public void testPartImpl() {
	ConfigImpl config1 = new ConfigImpl();
	PartTypeImpl part1 = new PartTypeImpl(new Name("EG100"), new Description("Gasoline, 100 kW"), new CategoryImpl("Engine"), new Incompatibilities(" "), new Requirements(" "));
	PartTypeImpl part2 = new PartTypeImpl(new Name("TM5"), new Description("Manual, 5 gears"), new CategoryImpl("Transmission"),new Incompatibilities(""), new Requirements(""));
	config1.addpart(part1);
	config1.addpart(part2);
	//System.out.println("coin");
	//System.out.println(config1.toString());
	config1.showlistpartcategories();
	}


	@Test
	public void Testshowpart() {
		CategoryImpl Engine = new CategoryImpl();
		CategoryImpl Transmission = new CategoryImpl();
		CategoryImpl Exterior = new CategoryImpl();
		CategoryImpl Interior = new CategoryImpl();
		
		
	}

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
