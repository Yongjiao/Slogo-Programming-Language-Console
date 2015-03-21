package commands.viewCommands;

import application.Pen;
import application.PenHandler;

public class PenUp extends ViewCommands{
	
	public PenUp(PenHandler p) {
		super(p);
	}
	
	public double execute() {
		super.getPenHandler().setPenStatus(0);
		return 0;
	}
	
}
