package model;
import java.util.ArrayList;

import Impl.CategoryImpl;
import Impl.IncompatibilityManagerImpl;


public class Catalogue {
	
	public String[][] catalogue;
	
	public Catalogue() {
		this.catalogue = new String[18][5]; 
		
		addPartTocatalogue(new CategoryImpl("Engine"), new PartName("EG100"),
				new PartDescription("Gasoline, 100 kW"), new IncompatibilityManagerImpl());

		addPartTocatalogue(new CategoryImpl("Engine"), new PartName("EG133"),
				new PartDescription("Gasoline, 133 kW"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Engine"), new PartName("EG210"),
				new PartDescription("Gasoline, 210 kW"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Engine"), new PartName("ED110"),
				new PartDescription("Diesel, 110 kW"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Engine"), new PartName("EG180"),
				new PartDescription("Diesel, 180 kW"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Engine"), new PartName("EH120"),
				new PartDescription("Gasoline/electric hybrid, 120 kW"), new IncompatibilityManagerImpl());	
		
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new PartName("TM5"),
				new PartDescription("Manual, 5 gears"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new PartName("TM6"),
				new PartDescription("Manual, 6 gears"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new PartName("TA5"),
				new PartDescription("Automatic, 5 gears"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new PartName("TS6"),
				new PartDescription("Sequential, 6 gears"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new PartName("TSF7"),
				new PartDescription("Sequential, 7 gears, 4 wheels drive"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Transmission"), new PartName("TC120"),
				new PartDescription("Converter, 120 kW max"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Exterior"), new PartName("XC"),
				new PartDescription("Classic paint"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Exterior"), new PartName("XM"),
				new PartDescription("Metalic paint"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Exterior"), new PartName("XS"),
				new PartDescription("Red paint and sport decoration"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Interior"), new PartName("IN"),
				new PartDescription("Standard interior"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Interior"), new PartName("IH"),
				new PartDescription("high-end interior"), new IncompatibilityManagerImpl());
		
		addPartTocatalogue(new CategoryImpl("Interior"), new PartName("IS"),
				new PartDescription("Sport finish"), new IncompatibilityManagerImpl());
		
	}
	
	public boolean addPartTocatalogue(CategoryImpl cat, PartName PartName, PartDescription PartDescription, IncompatibilityManagerImpl ir) {
		int i =0;
		while(this.catalogue[i][0] != null) {
			i ++;
		}
		this.catalogue[i][0] = cat.getCategory();
		this.catalogue[i][1] = PartName.getName();
		this.catalogue[i][2] = PartDescription.getDescription();
		this.catalogue[i][3] = ir.getIncompatibilities().toString();
		this.catalogue[i][4] = ir.getRequirements().toString();				
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