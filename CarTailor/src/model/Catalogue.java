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
 * @author Romiche
 *
 */
public class Catalogue {

	public Configuration config = new ConfigImpl();
	public Set<PartType> EngineParts = new HashSet<PartType>();
	public Set<PartType> TransmissionParts = new HashSet<PartType>();
	public Set<PartType> ExteriorParts = new HashSet<PartType>();
	public Set<PartType> InteriorParts = new HashSet<PartType>();
	private Map<Category, Set<PartType>> catalogue = new HashMap<Category, Set<PartType>>();
			
	public Category Engine = new CategoryImpl("Engine", EngineParts);
	public Category Transmission = new CategoryImpl("Transmission", TransmissionParts);
	public Category Exterior = new CategoryImpl("Exterior", ExteriorParts);
	public Category Interior = new CategoryImpl("Interior", InteriorParts);

	public PartType partengine1 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("EG100"), new PartDescription("Gasoline, 100 kW"));
	public PartType partengine2 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("EG133"), new PartDescription("Gasoline, 133 kW"));
	public PartType partengine3 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("EG210"), new PartDescription("Gasoline, 210 kW"));
	public PartType partengine4 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("ED110"), new PartDescription("Diesel, 110 kW"));
	public PartType partengine5 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("ED180"), new PartDescription("Diesel, 180 kW"));
	public PartType partengine6 = new PartTypeImpl(new CategoryImpl("Engine"), new PartName("EH120"), new PartDescription("Gasoline/electric hybrid, 120 kW"));
	public PartType parttrans1 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TM5"), new PartDescription("Manual, 5 gears"));
	public PartType parttrans2 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TM6"), new PartDescription("Manual, 6 gears"));
	public PartType parttrans3 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TA5"), new PartDescription("Automatic, 5 gears"));
	public PartType parttrans4 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TS6"), new PartDescription("Sequential, 6 gears"));
	public PartType parttrans5 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TSF7"), new PartDescription("Sequential, 7 gears, 4 wheels drive"));
	public PartType parttrans6 = new PartTypeImpl(new CategoryImpl("Transmission"), new PartName("TC120"), new PartDescription("Converter, 120 kW max"));
	public PartType partext1 = new PartTypeImpl(new CategoryImpl("Exterior"), new PartName("XC"), new PartDescription("Classic Paint"));
	public PartType partext2 = new PartTypeImpl(new CategoryImpl("Exterior"), new PartName("XM"), new PartDescription("Metallic Paint"));
	public PartType partext3 = new PartTypeImpl(new CategoryImpl("Exterior"), new PartName("XS"), new PartDescription("Red paint and sport decoration"));
	public PartType partint1 = new PartTypeImpl(new CategoryImpl("Interior"), new PartName("IN"), new PartDescription("Standard interior"));
	public PartType partint2 = new PartTypeImpl(new CategoryImpl("Interior"), new PartName("IH"), new PartDescription("High-end interior"));
	public PartType partint3 = new PartTypeImpl(new CategoryImpl("Interior"), new PartName("IS"), new PartDescription("Sport finish"));

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
	public void initialize() {

		EngineParts.add(partengine1);
		//partengine1.addRequirement();
		EngineParts.add(partengine2);
		EngineParts.add(partengine3);
		EngineParts.add(partengine4);
		EngineParts.add(partengine5);
		EngineParts.add(partengine6);
		TransmissionParts.add(parttrans1);
		TransmissionParts.add(parttrans2);
		TransmissionParts.add(parttrans3);
		TransmissionParts.add(parttrans4);
		TransmissionParts.add(parttrans5);
		TransmissionParts.add(parttrans6);
		ExteriorParts.add(partext1);
		ExteriorParts.add(partext2);
		ExteriorParts.add(partext3);
		InteriorParts.add(partint1);
		InteriorParts.add(partint2);
		InteriorParts.add(partint3);
		catalogue.put(Engine, EngineParts);
		catalogue.put(Transmission, TransmissionParts);
		catalogue.put(Exterior, ExteriorParts);
		catalogue.put(Interior, InteriorParts);
		System.out.println(catalogue);

	}

}
