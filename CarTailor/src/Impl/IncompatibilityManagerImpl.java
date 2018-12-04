package Impl;

import java.util.ArrayList;

import Interfaces.IncompatibilityManager;
import model.Catalogue;
import model.PartName;
import Interfaces.Part;

public class IncompatibilityManagerImpl implements IncompatibilityManager {
	public ArrayList<Part> incompatibility;
	public ArrayList<Part> requirement;
	
	public IncompatibilityManagerImpl() {
		this.incompatibility = new ArrayList<Part>();
		this.requirement = new ArrayList<Part>();
	}
	
	public IncompatibilityManagerImpl(ArrayList<Part> incompatibility, ArrayList<Part> requirement) {
		this.incompatibility = incompatibility;
		this.requirement = requirement;
	}
	
	
	public ArrayList<Part> getIncompatibilities() {
		return this.incompatibility;
	}
	
	public ArrayList<Part> getRequirements(){
		return this.requirement;
	}
	
	public boolean addRequirement(ArrayList<Part> requirement) {
		Catalogue catalogue = new Catalogue();
		for(Part p : requirement) {
			for(int i=0; i<catalogue.catalogue.length;i++) {
				if(p.getName().equals(catalogue.catalogue[i][1])) {
					Part pn = new Part(catalogue.catalogue[i][1]);
					this.requirement.add(pn);
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean addIncompatibility(ArrayList<Part> incompatibility) {
		Catalogue catalogue = new Catalogue();
		for(Part p : incompatibility) {
			for(int i=0; i<catalogue.catalogue.length;i++) {
				if(p.getName().equals(catalogue.catalogue[i][1])) {
					PartName pn = new PartName(catalogue.catalogue[i][1]);
					this.incompatibility.add(pn);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "[" + incompatibility + "," + requirement + "]";
	}
	
	

	
	
	
	

}
