package Impl;

import java.util.ArrayList;

import Interfaces.IncompatibilityManager;
import model.Catalogue;
import model.PartName;

public class IncompatibilityManagerImpl implements IncompatibilityManager {
	public ArrayList<PartName> incompatibility;
	public ArrayList<PartName> requirement;
	
	public IncompatibilityManagerImpl() {
		this.incompatibility = new ArrayList<PartName>();
		this.requirement = new ArrayList<PartName>();
	}
	
	public IncompatibilityManagerImpl(ArrayList<PartName> incompatibility, ArrayList<PartName> requirement) {
		this.incompatibility = incompatibility;
		this.requirement = requirement;
	}
	
	
	public ArrayList<PartName> getIncompatibilities() {
		return this.incompatibility;
	}
	
	public ArrayList<PartName> getRequirements(){
		return this.requirement;
	}
	
	public boolean addRequirement(ArrayList<PartName> requirement) {
		Catalogue catalogue = new Catalogue();
		for(PartName p : requirement) {
			for(int i=0; i<catalogue.catalogue.length;i++) {
				if(p.partName.equals(catalogue.catalogue[i][1])) {
					PartName pn = new PartName(catalogue.catalogue[i][1]);
					this.requirement.add(pn);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean addIncompatibility(ArrayList<PartName> incompatibility) {
		Catalogue catalogue = new Catalogue();
		for(PartName p : incompatibility) {
			for(int i=0; i<catalogue.catalogue.length;i++) {
				if(p.partName.equals(catalogue.catalogue[i][1])) {
					PartName pn = new PartName(catalogue.catalogue[i][1]);
					this.incompatibility.add(pn);
					return true;
				}
			}
		}
		return false;
	}

	
	
	
	

}
