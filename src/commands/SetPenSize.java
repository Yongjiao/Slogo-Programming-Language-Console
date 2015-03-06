package commands;

import java.util.ArrayList;

public class SetPenSize extends Display{
	
	public SetPenSize(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	// Fixed (Anika)
	public double execute() {
		double pixels = (Integer) params.get(params.size() - 1);
		super.myTurtleHandler.setPenWeight(pixels);
		return pixels;
	}

}
