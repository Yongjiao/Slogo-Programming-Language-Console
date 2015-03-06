package commands;

import java.util.ArrayList;

public class SetPalette extends Display{
	
	public SetPalette(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	//Fixed: Anika
	public double execute() {
		double index = (Integer) params.get(params.size() - 4);
		int r = (Integer) params.get(params.size() - 3);
		int g = (Integer) params.get(params.size() - 2);
		int b = (Integer) params.get(params.size() - 1);
		super.myTurtleHandler.setPaletteColor((int)index, r, g, b);
		return index;
	}

}
