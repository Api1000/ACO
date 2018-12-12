package Interfaces;

import java.util.Collection;
import java.util.Set;

import Impl.ConfigImpl;

public interface Configurator {

		public Collection<Category> getCategory();
		
		public Configuration getConfig();
		
		public IncompatibilityManager getIncompatibilityManager();
		
		public void newConfig();
		
		public void setConfig(ConfigImpl config);
		
		/**
		 * Test if the configurator is valid or not with a valid config and a valid
		 * incompatibilitymanager
		 * 
		 * @return true : is valid
		 * @return false : is not valid
		 */
		public boolean isValid();
		
		/**
		 * Initialize the configurator with parts in their categories and requirements
		 * and incompatibilities in the incompatibilitymanager
		 */
		public void initConfigurator();
		
		/**
		 * Add a part in the config of the configurator
		 * 
		 * @param PartType p
		 * @return true : added
		 * @return false : not added
		 */
		public boolean addPart(PartType p);
		
		/**
		 * Remove a part in the config of the configurator
		 * 
		 * @param PartType p
		 * @return true : removed
		 * @return false : not removed
		 */
		public boolean removePart(PartType p);
		
		/**
		 * Get a part from a category of the config of the configurator
		 * 
		 * @param Category
		 * @return a part from a category
		 */
		public PartType getMyPartFromCategory(Category c);
		
		/**
		 * Get all parts from a category of the config of the configurator
		 * 
		 * @param Category
		 * @return all parts from a category (Set)
		 */
		public Set<PartType> getPartsFromCategory(Category c);

	}

