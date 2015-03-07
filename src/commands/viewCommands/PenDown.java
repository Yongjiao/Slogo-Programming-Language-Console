package commands.viewCommands;

import application.Pen;
import application.PenHandler;

public class PenDown extends ViewCommands{
	
	public PenDown(PenHandler p) {
		super(p);
	}
	
	public double execute() {
		super.getPenHandler().setPenStatus(1);
		return 0;
	}

}
