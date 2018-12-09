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
