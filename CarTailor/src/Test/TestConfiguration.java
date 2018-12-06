package Test;
import static org.junit.Assert.*;

import java.util.Arrays;

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

	
	Configuration config1 = new ConfigImpl();
	Catalogue catalogue = new Catalogue();
	
	
	//catalogue.initialize();
	
	@Test
	public void TestAdd() {
	
		config1.AddPart(catalogue.partengine1);
		System.out.println(config1);
	}
	
	/*@Test
	public void testRemovePart1() {	
		assertTrue(config1.RemovePart(catalogue.partengine1)); 
	}
	
	@Test
	public void testRemovePart2() {	
		assertFalse(config1.RemovePart(catalogue.partengine2)); 
	}*/
}
