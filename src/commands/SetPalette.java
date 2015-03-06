package commands;

import java.util.ArrayList;

public class SetPalette extends Display{
	
	public SetPalette(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double index = (Integer) params.get(params.size() - 4);
		double r = (Integer) params.get(params.size() - 3);
		double g = (Integer) params.get(params.size() - 2);
		double b = (Integer) params.get(params.size() - 1);
		super.myTurtleHandler.setPalette(index, r, g, b);
		return index;
	}

}
