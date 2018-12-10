package Interfaces;

import java.util.Set;

public interface Category {

	public boolean addPartInCategory(PartType partCategory);

	public boolean removePartInCategory(PartType partCategory);

	public String getCategoryString();

	public Set<PartType> getPartImpl();
}
