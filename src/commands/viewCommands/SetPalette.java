package commands.viewCommands;

import java.util.ArrayList;

import commands.viewCommands.turtleCommands.Display;

public class SetPalette extends ViewCommands{
	
	public SetPalette(ArrayList<Object> p) {
		super.setParams(p);
	}
	
	//Fixed: Anika
	public double execute() {
		ArrayList<Object> params = super.getParams();
		double index = (Integer) params.get(params.size() - 4);
		int r = (Integer) params.get(params.size() - 3);
		int g = (Integer) params.get(params.size() - 2);
		int b = (Integer) params.get(params.size() - 1);
		
		//  color component values are nonnegative integers less than 256 
		// specifying an amount of red, green, and blue
		if (checkColorLimits(new int[]{r, g, b}))
		{
			super.getPen().setPaletteColor((int)index, r, g, b);
		}
		return index;
	}
	
	private boolean checkColorLimits(int[] components)
	{
		for (int component : components)
		{
			return ((!(component < 0)) && (component < 256));
		}
		return false;
	}

}
