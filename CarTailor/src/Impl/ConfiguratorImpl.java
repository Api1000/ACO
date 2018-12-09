package Impl;

import Interfaces.Configurator;
import Interfaces.PartType;
import model.Catalogue;

import java.util.Collection;
import java.util.HashSet;

import Interfaces.Category;


public class ConfiguratorImpl implements Configurator {

	private ConfigImpl myConfig;
	private Collection<Category> CategoryAvailable;
	private IncompatibilityManagerImpl compatibilityManager;

	public ConfiguratorImpl(){
		this.myConfig = new ConfigImpl();
		this.CategoryAvailable = new HashSet<Category>();
		this.compatibilityManager = new IncompatibilityManagerImpl(myConfig);
		initConfigurator();
	}

	public ConfigImpl getConfig() {
		return myConfig;
	}

	public Collection<Category> getCategory() {
		return CategoryAvailable;
	}

	public void newConfig() {
		myConfig = new ConfigImpl();
		compatibilityManager.ChangeConfig(myConfig);
	}

	public boolean addPart(PartType p) {
		boolean result = false;
		for(Category c : CategoryAvailable) {
			if(c.getCategoryString() == p.getCategory().getCategoryString()){
				Collection<PartType> myPartInC = c.getPartImpl();
				String pName = p.getName().partName;
				for(PartType pInC : myPartInC){
					if(pInC.getName().partName == pName){
						if(!myConfig.getcatalogue().containsValue(pInC)){
							myConfig.AddPart(pInC);
							result = true;
						}
						break;
					}
				}
				break;
			}
		}
		return result;
	}

	public boolean removePart(PartType p) {
		boolean result = false;
		Collection<Category> CinMyConfig = myConfig.getcatalogue().keySet();
		for(Category c : CinMyConfig) {
			if(c.getCategoryString() == p.getCategory().getCategoryString()){
				Collection<PartType> myPartInC = c.getPartImpl();
				String pName = p.getName().partName;
				for(PartType pInC : myPartInC){
					if(pInC.getName().partName == pName){
						result = true;
						myConfig.RemovePart(pInC);
						break;
					}
				}
				break;
			}
		}
		return result;
	}

	public PartType getMyPartFromCategory(Category c) {
		Collection<Category> CinMyConfig = myConfig.getcatalogue().keySet();
		String cToString = c.getCategoryString();
		for(Category cIn : CinMyConfig) {
			if(cIn.getCategoryString() == cToString)
				return myConfig.ShowMyPartFromCategory(cIn);
		}
		return null;
		
	}
	
	public IncompatibilityManagerImpl getCompapatibilityManager() {
		return compatibilityManager;
	}
	
	public boolean isValide(){
		return (myConfig.isValid() && compatibilityManager.isCompatible());	
	}
	
	public void initConfigurator(){
		
		//Init of the categories available and their PartType 
		Catalogue cat = new Catalogue();
		
		Category Engine = new CategoryImpl("Engine");
		Category Transmission = new CategoryImpl("Transmission");
		Category Exterior = new CategoryImpl("Exterior");
		Category Interior = new CategoryImpl("Interior");
		
		Engine.addCategory(cat.partengine1);
		Engine.addCategory(cat.partengine2);
		Engine.addCategory(cat.partengine3);
		Engine.addCategory(cat.partengine4);
		Engine.addCategory(cat.partengine5);
		Engine.addCategory(cat.partengine6);

		Transmission.addCategory(cat.parttrans1);
		Transmission.addCategory(cat.parttrans2);
		Transmission.addCategory(cat.parttrans3);
		Transmission.addCategory(cat.parttrans4);	
		Transmission.addCategory(cat.parttrans5);
		Transmission.addCategory(cat.parttrans6);
		
		Exterior.addCategory(cat.partext1);
		Exterior.addCategory(cat.partext2);	
		Exterior.addCategory(cat.partext3);	
		
		Interior.addCategory(cat.partint1);
		Interior.addCategory(cat.partint2);
		Interior.addCategory(cat.partint3);
		
//		PartType EG100= new PartTypeImpl();EG100.SetCategory(Engine); EG100.SetPartDescription(new PartDescription("Gasoline, 100kW")); EG100.SetPartName(new PartName("EG100"));
//		PartType EG133= new PartTypeImpl();EG133.SetCategory(Engine);EG133.SetPartDescription(new PartDescription("Gasoline, 133kW"));EG133.SetPartName(new PartName("EG133"));
//		PartType EG210= new PartTypeImpl();EG210.SetCategory(Engine);EG210.SetPartDescription(new PartDescription("Gasoline, 210kW"));EG210.SetPartName(new PartName("EG210"));	
//		PartType ED110= new PartTypeImpl();ED110.SetCategory(Engine);ED110.SetPartDescription(new PartDescription("Diesel, 110kW"));ED110.SetPartName(new PartName("ED110"));
//		PartType ED180= new PartTypeImpl();ED180.SetCategory(Engine);ED180.SetPartDescription(new PartDescription("Diesel, 180kW"));ED180.SetPartName(new PartName("ED180"));
//		PartType EH120= new PartTypeImpl();EH120.SetCategory(Engine);EH120.SetPartDescription(new PartDescription("Gasoline/electric hybrid, 120kW"));EH120.SetPartName(new PartName("EH120"));
		
//		PartType TM5= new PartTypeImpl();TM5.SetCategory(Transmission);TM5.SetPartDescription(new PartDescription("Manual, 5 gears"));TM5.SetPartName(new PartName("TM5"));
//		PartType TM6= new PartTypeImpl();TM6.SetCategory(Transmission);TM6.SetPartDescription(new PartDescription("Manual, 6 gears"));TM6.SetPartName(new PartName("TM6"));
//		PartType TA5= new PartTypeImpl();TA5.SetCategory(Transmission);TA5.SetPartDescription(new PartDescription("Automatic, 5 gears"));TA5.SetPartName(new PartName("TA5"));
//		PartType TS6= new PartTypeImpl();TS6.SetCategory(Transmission);TS6.SetPartDescription(new PartDescription("sequential, 6 gears"));TS6.SetPartName(new PartName("TS6"));
//		PartType TSF7= new PartTypeImpl();TSF7.SetCategory(Transmission);TSF7.SetPartDescription(new PartDescription("Sequential, 7 gears, 4 wheels drive"));TSF7.SetPartName(new PartName("TSF7"));
//		PartType TC120= new PartTypeImpl();TC120.SetCategory(Transmission);TC120.SetPartDescription(new PartDescription("Converter, 120 kW max"));TC120.SetPartName(new PartName("TC120"));
		
//		PartType XC = new PartTypeImpl();XC.SetCategory(Exterior);XC.SetPartDescription(new PartDescription("Classic paint"));XC.SetPartName(new PartName("XC"));
//		PartType XM = new PartTypeImpl();XM.SetCategory(Exterior);XM.SetPartDescription(new PartDescription("Metallic paint"));XM.SetPartName(new PartName("XM"));
//		PartType XS = new PartTypeImpl();XS.SetCategory(Exterior);XS.SetPartDescription(new PartDescription("Red paint and sport decoration"));XS.SetPartName(new PartName("XS"));
		
//		PartType IN = new PartTypeImpl();IN.SetCategory(Interior);IN.SetPartDescription(new PartDescription("Standard interior"));IN.SetPartName(new PartName("IN"));
//		PartType IH = new PartTypeImpl();IH.SetCategory(Interior);IH.SetPartDescription(new PartDescription("High-end interior"));IH.SetPartName(new PartName("IH"));
//		PartType IS = new PartTypeImpl();IS.SetCategory(Interior);IS.SetPartDescription(new PartDescription("Sport finish"));IS.SetPartName(new PartName("IS"));
		
		
		this.CategoryAvailable.add(Engine); this.CategoryAvailable.add(Transmission); this.CategoryAvailable.add(Exterior); this.CategoryAvailable.add(Interior);
		
		//end of category init
		
		//init of CompatibilityManager
		
		this.compatibilityManager.addRequirement(cat.partengine6, cat.parttrans6);
		
		this.compatibilityManager.addRequirement(cat.parttrans6, cat.partengine6);
		
		this.compatibilityManager.addIncompatibility(cat.parttrans3, cat.partengine1);
		
		this.compatibilityManager.addIncompatibility(cat.parttrans5, cat.partengine1);
		this.compatibilityManager.addIncompatibility(cat.parttrans5, cat.partengine2);
		this.compatibilityManager.addIncompatibility(cat.parttrans5, cat.partengine4);
		
		this.compatibilityManager.addIncompatibility(cat.partext1, cat.partengine3);
		
		this.compatibilityManager.addIncompatibility(cat.partext2, cat.partengine1);
		
		this.compatibilityManager.addIncompatibility(cat.partext3, cat.partengine1);
		this.compatibilityManager.addRequirement(cat.partext3, cat.partint3);
		
		this.compatibilityManager.addRequirement(cat.partint3, cat.partext3);
		this.compatibilityManager.addIncompatibility(cat.partint3, cat.partengine1);
		this.compatibilityManager.addIncompatibility(cat.partint3, cat.parttrans1);
	}

}
