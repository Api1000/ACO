package Interfaces;

import java.util.Collection;

public interface Configurator {

		
		//public void init() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
		
		public Collection<Category> getCategory();
		
		public Configuration getConfig();
		
		public IncompatibilityManager getCompapatibilityManager();
		
		public boolean isValide();
		
		public void newConfig();
		
		public boolean addPart(PartType p);
		
		public boolean removePart(PartType p);
		
		public PartType getMyPartFromCategory(Category c);
		

	}

