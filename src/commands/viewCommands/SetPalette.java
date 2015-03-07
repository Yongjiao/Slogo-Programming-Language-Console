package commands.viewCommands;

import java.util.ArrayList;

import application.Pen;
import javafx.scene.paint.Color;

public class SetPalette extends ViewCommands{
	private int[] listOfIndices;
	
	public SetPalette(ArrayList<Object> p, Pen pen) {
		super(p, pen);
	}
	
	//Fixed: Anika
	public double execute() {

		ArrayList<Object> params = super.getParams();
		double index = (Integer) params.get(params.size() - 4);
		listOfIndices[0] = (Integer) params.get(params.size() - 3);
		listOfIndices[1] = (Integer) params.get(params.size() - 2);
		listOfIndices[2] = (Integer) params.get(params.size() - 1);
		
		//  color component values are nonnegative integers less than 256 
		// specifying an amount of red, green, and blue
		if (checkColorLimits())
		{
			super.getPen().setPaletteColor((int)index, listOfIndices[0], listOfIndices[1], listOfIndices[2]);
		}
		return index;
	}
	
	private boolean checkColorLimits()
	{
		for (int component : listOfIndices)
		{
			return ((!(component < 0)) && (component < 256));
		}
		return false;
	}

}
