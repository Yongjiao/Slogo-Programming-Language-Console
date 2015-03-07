package commands.viewCommands;

import application.Pen;
import application.PenHandler;


public class PenColor extends ViewCommands{
	
	public PenColor(PenHandler p) {
		super(p);
	}
	//Anika
	public double execute() {
		return super.getPenHandler().getPenColorIndex();
	}

}
