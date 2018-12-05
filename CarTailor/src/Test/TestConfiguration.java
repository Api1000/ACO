package Test;
import static org.junit.Assert.*;
import org.junit.Test;

import Impl.ConfigImpl;
import Impl.PartTypeImpl;
import Interfaces.Configuration;
import Interfaces.PartType;
import model.Catalogue;

public class TestConfiguration {

	
	Configuration c = new ConfigImpl();
	PartType partEngine = new PartTypeImpl();
	Catalogue catalogue = new Catalogue();
	
	@Test
	public void TestAdd() {
		c.getCatalogue();
		System.out.println(catalogue.toString());
	}
	
}
