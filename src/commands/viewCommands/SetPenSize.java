package commands.viewCommands;

import java.util.ArrayList;

import application.Pen;

public class SetPenSize extends ViewCommands{
	
	public SetPenSize(ArrayList<Object> p, Pen pen) {
		super(p, pen);
	}
	
	// Fixed (Anika)
	public double execute() {
		double pixels = (Double) super.getParams().get(super.getParams().size() - 1);
		super.getPen().setWeight(pixels);
		return pixels;
	}

}
