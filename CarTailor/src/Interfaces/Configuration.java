package Interfaces;

import java.util.Set;
import java.util.Collection;
import java.util.Map;

import model.PartName;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public interface Configuration {

	public boolean AddPart(PartType parameter);

	public boolean RemovePart(PartType parameter);

	public PartType ShowMyPartFromCategory(Category parameter);

	public boolean isValid();

	public Map<Category, PartType> getcatalogue();

	public Collection<PartType> getMyParts();

}
