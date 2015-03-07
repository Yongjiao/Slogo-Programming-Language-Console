package commands.viewCommands;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import commands.viewCommands.turtleCommands.Display;

public class SetPalette extends ViewCommands{
	
	public SetPalette(ArrayList<Object> p) {
		super.setParams(p);
	}
	
	//Fixed: Anika
	public double execute() {
		double index = (Integer) super.getParams().get(super.getParams().size() - 4);
		int r = (Integer) super.getParams().get(super.getParams().size() - 3);
		int g = (Integer) super.getParams().get(super.getParams().size() - 2);
		int b = (Integer) super.getParams().get(super.getParams().size() - 1);
		
		//  color component values are nonnegative integers less than 256 
		// specifying an amount of red, green, and blue
		if (checkColorLimits(new int[]{r, g, b}))
		{
			Color myColor = new Color(r, g, b, 1.0);
			super.getPen().addToPalette((int)index, myColor);
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
