package Interfaces;

import Impl.CategoryImpl;
import Impl.IncompatibilityManagerImpl;
import model.PartDescription;
import model.PartName;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public interface Part {

	public CategoryImpl getCategory();

	public void setCategory(CategoryImpl category);

	public PartName getName();

	public void setName(PartName name);

	public PartDescription getDescription();

	public void setDescription(PartDescription description);

	public IncompatibilityManagerImpl getIm();

	public void setIm(IncompatibilityManagerImpl im);

}
