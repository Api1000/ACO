package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Impl.CategoryImpl;
import Impl.ConfigImpl;
import Impl.IncompatibilityManagerImpl;
import Impl.PartTypeImpl;
import Interfaces.Category;
import Interfaces.Configuration;
import Interfaces.PartType;


/**
 * All PartTypes for the configuration of the car are available in this catalog
 * If you want to test some methods, you have to pick up PartType here.
 * In an interface, this catalog is expose to the customer. So, he will choose the configuration of his car
 * @author Romain
 *
 */
public class Catalogue {

	private final Configuration config = new ConfigImpl();
	public final Set<PartType> EngineParts = new HashSet<>();
	public final Set<PartType> TransmissionParts = new HashSet<>();
	public final Set<PartType> ExteriorParts = new HashSet<>();
	public final Set<PartType> InteriorParts = new HashSet<>();
	public final Map<Category, Set<PartType>> catalogue = new HashMap<>();
	public Map<Category, PartType> cataconfig = new HashMap<>(); 
			
	public Category Engine = new CategoryImpl();
	public Category Transmission = new CategoryImpl();
	public Category Exterior = new CategoryImpl();
	public Category Interior = new CategoryImpl();

	public final PartType partengine1 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("EG100"), new PartDescription("Gasoline, 100 kW"));
	public final PartType partengine2 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("EG133"), new PartDescription("Gasoline, 133 kW"));
	public final PartType partengine3 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("EG210"), new PartDescription("Gasoline, 210 kW"));
	public final PartType partengine4 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("ED110"), new PartDescription("Diesel, 110 kW"));
	public final PartType partengine5 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("ED180"), new PartDescription("Diesel, 180 kW"));
	public final PartType partengine6 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("EH120"), new PartDescription("Gasoline/electric hybrid, 120 kW"));
	public final PartType parttrans1 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TM5"), new PartDescription("Manual, 5 gears"));
	public final PartType parttrans2 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TM6"), new PartDescription("Manual, 6 gears"));
	public final PartType parttrans3 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TA5"), new PartDescription("Automatic, 5 gears"));
	public final PartType parttrans4 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TS6"), new PartDescription("Sequential, 6 gears"));
	public final PartType parttrans5 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TSF7"), new PartDescription("Sequential, 7 gears, 4 wheels drive"));
	public final PartType parttrans6 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TC120"), new PartDescription("Converter, 120 kW max"));
	public final PartType partext1 = new PartTypeImpl(new CategoryImpl("Exterior"), new PartName("XC"), new PartDescription("Classic Paint"));
	public final PartType partext2 = new PartTypeImpl(new CategoryImpl("Exterior"), new PartName("XM"), new PartDescription("Metallic Paint"));
	public final PartType partext3 = new PartTypeImpl(new CategoryImpl("Exterior"), new PartName("XS"), new PartDescription("Red paint and sport decoration"));
	public final PartType partint1 = new PartTypeImpl(new CategoryImpl("Interior"), new PartName("IN"), new PartDescription("Standard interior"));
	public final PartType partint2 = new PartTypeImpl(new CategoryImpl("Interior"), new PartName("IH"), new PartDescription("High-end interior"));
	public final PartType partint3 = new PartTypeImpl(new CategoryImpl("Interior"), new PartName("IS"), new PartDescription("Sport finish"));

	/*public void initcategory() {
		catalogue.put(Engine, PartType);
	}
	
	public void init() {
		EngineParts.add(partengine1);
		catalogue.put(Engine, EngineParts);
		System.out.println(catalogue.toString());
		config = new ConfigImpl(catalogue);
		System.out.println(config.toString());
    }*/
		
	
	/*
	 * This method implement the initialization of the catalog in the configuration
	 * It put all the PartType of the catalog in the config
	 * Just serve to see all PartType 
	 */

}
