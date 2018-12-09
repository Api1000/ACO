package Impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import Interfaces.Category;
import Interfaces.IncompatibilityManager;
import Interfaces.Part;
import Interfaces.PartType;
import model.PartDescription;
import model.PartName;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class PartTypeImpl implements PartType {

	private Category category;
	private PartName name;
	private PartDescription description;
	private IncompatibilityManager im;

	public PartTypeImpl() {
		this.category = new CategoryImpl();
		this.name = new PartName();
		this.description = new PartDescription();
		//this.im = new IncompatibilityManagerImpl();
	}

	public PartTypeImpl(Category category, PartName name, PartDescription description) {
		this.category = category;
		this.name = name;
		this.description = description;
	}
	public PartTypeImpl(PartName name, PartDescription description) {
		this.name = name;
		this.description = description;
	}

	/*public PartTypeImpl(PartName name, PartDescription description, IncompatibilityManagerImpl im) {
		this.category = category;
		this.name = name;
		this.description = description;
		this.im = im;
	}*/

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public PartName getName() {
		return name;
	}

	public void setName(PartName name) {
		this.name = name;
	}

	public PartDescription getDescription() {
		return description;
	}

	public void setDescription(PartDescription description) {
		this.description = description;
	}

	public IncompatibilityManager getIm() {
		return im;
	}

	public void setIm(IncompatibilityManager im) {
		this.im = im;
	}

	@Override
	public String toString() {
		return name + " | " + description + " | " + im;
	}

}
