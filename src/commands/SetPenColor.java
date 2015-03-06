package commands;

import java.util.ArrayList;

public class SetPenColor extends Display{
	
	public SetPenColor(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	// Modified: Anika
	public double execute() {
		double index = (Integer) params.get(params.size() - 1);
		super.myTurtleHandler.setPenColor((int)index);
		return index;
	}

}
