package model;
import java.util.ArrayList;

import Impl.CategoryImpl;
import Impl.IncompatibilitiesImpl;
import Impl.RequirementsImpl;

public class Catalogue {
	
	public String[][] catalogue;
	
	public Catalogue() {
		this.catalogue = new String[18][5]; 
		
		addPartTocatalogue(new CategoryImpl("Engine"), new Name("EG100"),
				new Description("Gasoline, 100 kW"), new IncompatibilitiesImpl(), new RequirementsImpl());

		addPartTocatalogue(new CategoryImpl("Engine"), new Name("EG133"),
				new Description("Gasoline, 133 kW"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Engine"), new Name("EG210"),
				new Description("Gasoline, 210 kW"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Engine"), new Name("ED110"),
				new Description("Diesel, 110 kW"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Engine"), new Name("EG180"),
				new Description("Diesel, 180 kW"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Engine"), new Name("EH120"),
				new Description("Gasoline/electric hybrid, 120 kW"), new IncompatibilitiesImpl(), new RequirementsImpl());	
		
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new Name("TM5"),
				new Description("Manual, 5 gears"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new Name("TM6"),
				new Description("Manual, 6 gears"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new Name("TA5"),
				new Description("Automatic, 5 gears"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new Name("TS6"),
				new Description("Sequential, 6 gears"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new Name("TSF7"),
				new Description("Sequential, 7 gears, 4 wheels drive"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new Name("TC120"),
				new Description("Converter, 120 kW max"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Exterior"), new Name("XC"),
				new Description("Classic paint"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Exterior"), new Name("XM"),
				new Description("Metalic paint"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Exterior"), new Name("XS"),
				new Description("Red paint and sport decoration"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Interior"), new Name("IN"),
				new Description("Standard interior"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Interior"), new Name("IH"),
				new Description("high-end interior"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
		addPartTocatalogue(new CategoryImpl("Interior"), new Name("IS"),
				new Description("Sport finish"), new IncompatibilitiesImpl(), new RequirementsImpl());
		
	}
	
	public boolean addPartTocatalogue(CategoryImpl cat, Name name, Description description, IncompatibilitiesImpl compat, RequirementsImpl require) {
		int i =0;
		while(this.catalogue[i][0] != null) {
			i ++;
		}
		this.catalogue[i][0] = cat.getCategory();
		this.catalogue[i][1] = name.getName();
		this.catalogue[i][2] = description.getDescription();
		this.catalogue[i][3] = compat.getIncompatibility();
		this.catalogue[i][4] = require.getRequirement();				
		return true;
	}
	
	public ArrayList<CategoryImpl> getCat(){
		ArrayList<CategoryImpl> res = new ArrayList<CategoryImpl>();
		boolean exist = false;
		for(int i = 0; i < catalogue.length; i++) {
			exist = false;
			CategoryImpl c = new CategoryImpl(catalogue[i][0]);
			for(int j = 0; j< res.size(); j++) {
				if(c.getCategory().equals(res.get(j).getCategory())) {
					exist = true;
				}
			}
			if(!exist) {
				res.add(c);
			}
		}
		return res;
	}
}