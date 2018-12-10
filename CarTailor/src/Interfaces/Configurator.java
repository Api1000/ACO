package Interfaces;

import java.util.Collection;

import Impl.ConfigImpl;

public interface Configurator {

		public Collection<Category> getCategory();
		
		public Configuration getConfig();
		
		public IncompatibilityManager getIncompatibilityManager();
		
		public void setConfig(ConfigImpl config);
		
		public boolean isValid();
		
		public void newConfig();
		
		public boolean addPart(PartType p);
		
		public boolean removePart(PartType p);
		
		public PartType getMyPartFromCategory(Category c);
		

	}

