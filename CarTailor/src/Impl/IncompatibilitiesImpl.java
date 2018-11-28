package Impl;

import Interfaces.Incompatibilities;

public class IncompatibilitiesImpl implements Incompatibilities {
	public String Incompatibility;
	
	public IncompatibilitiesImpl() {
		this.Incompatibility = new String();
	}
	
	public IncompatibilitiesImpl(String incompatibility) {
		this.Incompatibility = incompatibility;
	}

	public String getIncompatibility() {
		if(this.Incompatibility != null)
			return this.Incompatibility.toString();
		return null;
	}

	public void setIncompatibility(String incompatibility) {
		Incompatibility = incompatibility;
	}

	@Override
	public String toString() {
		return "Incompatibilities [Incompatibility=" + Incompatibility;
				//+ ", part=" + part + "]";
	}
}
