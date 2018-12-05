package Test;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


import org.junit.Test;
import Impl.*;
import junit.framework.TestCase;
import model.PartDescription;
import model.PartName;
import Interfaces.*;


public class TestConfigImpl extends TestCase {
	
	Configuration c = new ConfigImpl();
	PartType partEngine = new PartTypeImpl();
	PartType partCantBeAdded = new PartTypeImpl();
	PartType partTransmission = new PartTypeImpl();
	Map<Category,Set<PartType>> catalog = new HashMap<Category, Set<PartType>>();
	Set<PartType> setEngine = new HashSet<PartType>();
	Set<PartType> setTransmission = new HashSet<PartType>();
	Set<PartType> setError = new HashSet<PartType>();
	Category cEngine = new CategoryImpl();
	Category cTransmission = new CategoryImpl();
	Category cError = new CategoryImpl();
	
	@Override
    protected void setUp() throws Exception
    {
		partEngine.setCategory(new CategoryImpl("engine"));
		partEngine.setName(new PartName("EG100"));
		partEngine.setDescription(new PartDescription("LALALA"));
		
		partCantBeAdded.setCategory(new CategoryImpl("ERROR"));
		partCantBeAdded.setName(new PartName("E404"));
		partCantBeAdded.setDescription(new PartDescription("Page not found"));
			
		partTransmission.setCategory(new CategoryImpl("transmision"));
		partTransmission.setName(new PartName("TC100"));
		partTransmission.setDescription(new PartDescription("LALALA"));
		
		setEngine.add(partEngine);
		setTransmission.add(partTransmission);
		setError.add(partCantBeAdded);
		
		cEngine = new CategoryImpl("engine",setEngine);
		cTransmission = new CategoryImpl("transmission", setTransmission);
		cError = new CategoryImpl("error",setError);
		
		catalog.put(cEngine, setEngine);
		catalog.put(cTransmission, setTransmission);
		
		c = new ConfigImpl(catalog);
    }

	/*
	 * Can't add if the Part doesn't exist !
	 */
	@Test
	public void testAddPart1() {
		assertFalse(c.AddPart(partCantBeAdded)); 
		//This Part does not exist in the catalog;
	}
	
	/*
	 * Add properly to the current configuration
	 */
	
	@Test
	public void testAddPart2() {
		assertTrue(c.AddPart(partEngine));
		System.out.println(c.toString());
		/*assertEquals(c.toString(), "My configuration :\n" + "Category : engine , Name : EG100 , "
				+ "Description : LALALA , Requirements :  , Incompatibilities : ");
		for(PartType pt : c.getMyConfig())
		System.out.println(pt.toString());*/
	}
	
	
	/*
	 * Can't add twice a same part 
	 */

	@Test
	public void testAddPart3() {
		assertTrue(c.AddPart(partEngine));
		assertFalse(c.AddPart(partEngine));
		/*assertEquals(c.toString(), "My configuration :\n" + "Category : engine , Name : EG100 , "
				+ "Description : LALALA , Requirements :  , Incompatibilities : ");*/
	}
	
	/*
	 * Can't remove a Part if it's not in the current configuration
	 */
	
	@Test
	public void testRemovePart1() {	
		assertFalse(c.RemovePart(partEngine)); 
	}
	
	/*
	 * Remove properly to the current configuration
	 */
	
	@Test
	public void testRemovePart2() {
		Configuration c1 = new ConfigImpl(setEngine,catalog);
		assertTrue(c1.RemovePart(partEngine));
		assertEquals(c1.toString(), "My configuration :\n");
	}
	
	/*
	 * Can't select a Category if it does not exist
	 */
	@Test
	public void testSelectCategory1(){
		try {
			c.SelectCategory(cError);
		}
		catch (AssertionError e){
			assertEquals("java.lang.AssertionError: this category does not exist", e.toString());
		}
		
	}
	
	/*
	 * Select properly a Category from those available
	 */
	
	@Test
	public void testSelectCategory2() {
		assertEquals(c.SelectCategory(cEngine),cEngine.getCategory());
	}
	
	/*
	 * Can't show the list of available parts if there is none;
	 */
	
	@Test
	public void testShowListPart1(){
		Configuration c1 = new ConfigImpl();
		try {
			c1.ShowListofParts();
		}
		catch (AssertionError e){
			assertEquals("java.lang.AssertionError: There is no available part", e.toString());
		}
		
	}
	
	/*
	 * 
	 */
	
	@Test
	public void testShowListPart2(){
		
		Set<PartType> toShow = new HashSet<PartType>();
		toShow.add(partEngine);
		toShow.add(partTransmission);
		
		assertEquals(c.ShowListofParts(),toShow);
		
	}
	
	/*
	 * Can't show the list of categories if there is none;
	 */
	
	@Test
	public void testShowListCategory1(){
		Configuration c1 = new ConfigImpl();
		Set<Category> result = new HashSet<Category>();
		assertEquals(result,c1.ShowListCategory());
		
	}
	
	/*
	 * Show properly the list of category
	 */
	
	@Test
	public void testShowListCategory2(){
		Set<Category> result = new HashSet<Category>();
		result.add(cTransmission);
		result.add(cEngine);
		assertEquals(result,c.ShowListCategory());
		
	}
	
	/*
	 * Show properly a part from a given category;
	 */
	

	/*@Test
	public void testShowListPartFromCategory1(){		
		Set<PartType> toShow = new Set<PartType>();
		toShow.add(partEngine);	
		assertEquals(c.ShowListPartFromCategory(cEngine),toShow);
		
	}*/
	
	/*
	 * can't show a list of part from a category
	 * if this category is not added in the available categories;
	 */

	/*@Test
	public void testShowListPartFromCategory2(){
		try {
			c.ShowListPartFromCategory(cError);
		}
		catch (AssertionError e){
			assertEquals("java.lang.AssertionError: This category does not exist", e.toString());
		}
	}*/
	
	
	@Test
	public void isCompatible1() {
		
	}
	
	@Test
	public void isCompatible2() {
		
	}
	
	@Test
	public void isValide1() {
		
	}
	
	@Test
	public void isValide2() {
		
	}
	
}
