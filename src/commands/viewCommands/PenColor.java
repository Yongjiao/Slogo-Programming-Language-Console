package commands.viewCommands;

import application.Pen;


public class PenColor extends ViewCommands{
	
	public PenColor(Pen p) {
		super(p);
	}
	//Anika
	public double execute() {
		return super.getPen().getCurrentColorIndexFromPalette();
	}

}
