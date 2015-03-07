package commands.viewCommands;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class SetPalette extends ViewCommands{
	
	public SetPalette(ArrayList<Object> p) {
		super.setParams(p);
	}
	
	//Fixed: Anika
	public double execute() {

		ArrayList<Object> params = super.getParams();
		double index = (Integer) params.get(params.size() - 4);
		int redIndex = (Integer) params.get(params.size() - 3);
		int greenIndex = (Integer) params.get(params.size() - 2);
		int blueIndex = (Integer) params.get(params.size() - 1);
		
		//  color component values are nonnegative integers less than 256 
		// specifying an amount of red, green, and blue
		if (checkColorLimits(new int[]{redIndex, greenIndex, blueIndex}))
		{
			super.getPen().setPaletteColor((int)index, redIndex, greenIndex, blueIndex);
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
