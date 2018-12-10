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
		this.CategoryAvailable = new HashSet<>();
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

	public void setConfig(ConfigImpl config){
		this.myConfig = config;
		this.compatibilityManager.ChangeConfig(config);
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
	
	public boolean isValid(){
		return (myConfig.isValid() && compatibilityManager.isCompatible());	
	}
	
	public void initConfigurator(){
		
		//Init of the categories available and their PartType 
		Catalogue cat = new Catalogue();
		
		Category Engine = new CategoryImpl("Engine");
		Category Transmission = new CategoryImpl("Transmission");
		Category Exterior = new CategoryImpl("Exterior");
		Category Interior = new CategoryImpl("Interior");
		
		Engine.addPartInCategory(cat.partengine1);
		Engine.addPartInCategory(cat.partengine2);
		Engine.addPartInCategory(cat.partengine3);
		Engine.addPartInCategory(cat.partengine4);
		Engine.addPartInCategory(cat.partengine5);
		Engine.addPartInCategory(cat.partengine6);

		Transmission.addPartInCategory(cat.parttrans1);
		Transmission.addPartInCategory(cat.parttrans2);
		Transmission.addPartInCategory(cat.parttrans3);
		Transmission.addPartInCategory(cat.parttrans4);	
		Transmission.addPartInCategory(cat.parttrans5);
		Transmission.addPartInCategory(cat.parttrans6);
		
		Exterior.addPartInCategory(cat.partext1);
		Exterior.addPartInCategory(cat.partext2);	
		Exterior.addPartInCategory(cat.partext3);	
		
		Interior.addPartInCategory(cat.partint1);
		Interior.addPartInCategory(cat.partint2);
		Interior.addPartInCategory(cat.partint3);
		
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

	@Override
	public String toString() {
		return "MyConfig ==> " + myConfig + "\n\nCategory ==> " + CategoryAvailable
				+ "\n\nIncompatibilityManager ==> " + compatibilityManager;
	}

	
	
	

}
