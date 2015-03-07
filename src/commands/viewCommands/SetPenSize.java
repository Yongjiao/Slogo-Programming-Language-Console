package commands.viewCommands;

import java.util.ArrayList;

import application.Pen;
import application.PenHandler;

public class SetPenSize extends ViewCommands{
	
	public SetPenSize(ArrayList<Object> p, PenHandler pen) {
		super(p, pen);
	}
	
	// Fixed (Anika)
	public double execute() {
		double pixels = (Double) super.getParams().get(super.getParams().size() - 1);
		super.getPenHandler().setPenWeight(pixels);
		return pixels;
	}

}
