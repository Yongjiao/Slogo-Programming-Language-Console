package commands.viewCommands;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public class SetPalette extends ViewCommands{
	
	public SetPalette(ArrayList<Object> p) {
		super.setParams(p);
	}
	
	//Fixed: Anika
	public double execute() {
//<<<<<<< HEAD
//		double index = (Integer) super.getParams().get(super.getParams().size() - 4);
//		int r = (Integer) super.getParams().get(super.getParams().size() - 3);
//		int g = (Integer) super.getParams().get(super.getParams().size() - 2);
//		int b = (Integer) super.getParams().get(super.getParams().size() - 1);
//=======
		ArrayList<Object> params = super.getParams();
		double index = (Integer) params.get(params.size() - 4);
		int r = (Integer) params.get(params.size() - 3);
		int g = (Integer) params.get(params.size() - 2);
		int b = (Integer) params.get(params.size() - 1);
//>>>>>>> 30e0046f1ae44ec28007a04c5d5284e8b12bb53b
		
		//  color component values are nonnegative integers less than 256 
		// specifying an amount of red, green, and blue
		if (checkColorLimits(new int[]{r, g, b}))
		{
//<<<<<<< HEAD
			Color myColor = new Color(r, g, b, 1.0);
			super.getPen().addToPalette((int)index, myColor);
//=======
//			super.getPen().setPaletteColor((int)index, r, g, b);
//>>>>>>> 30e0046f1ae44ec28007a04c5d5284e8b12bb53b
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
