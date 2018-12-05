package Interfaces;
import java.util.HashSet;
import java.util.Set;

import Impl.CategoryImpl;
import Impl.IncompatibilityManagerImpl;
import model.PartDescription;
import model.PartName;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public interface PartType
{

	public Category getCategory();

	public void setCategory(Category category);

	public PartName getName();

	public void setName(PartName name);

	public PartDescription getDescription();

	public void setDescription(PartDescription description);

	public IncompatibilityManager getIm();

	public void setIm(IncompatibilityManager im);
	
	public String toString();
	
	
}

