package Test;
import static org.junit.Assert.*;
import org.junit.Test;

import Impl.ConfigImpl;
import Interfaces.Configuration;
import Interfaces.PartType;
import model.Catalogue;

public class TestCategory {

	private Configuration config1 = new ConfigImpl();
	private Catalogue catalogue = new Catalogue();

	private PartType partype1 = catalogue.partengine1;
	private PartType partype2 = catalogue.partengine2;
	private PartType partype3 = catalogue.partengine3;
	
	@Test
	public void TestAddCategory() {
		
	assertTrue(config1.addCategory(partype1));	
	}
	
	@Test
	public void TestRemoveCategory() {
		
	}
}
