package Interfaces;

import java.util.Set;

public interface Category {

	public boolean addCategory(PartType partCategory);

	public boolean removeCategory(PartType partCategory);

	public String getCategoryString();

	public Set<PartType> getPartImpl();
}
