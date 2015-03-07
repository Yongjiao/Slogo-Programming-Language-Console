package commands.viewCommands;

import application.Pen;

public class PenUp extends ViewCommands{
	
	public PenUp(Pen p) {
		super(p);
	}
	
	public double execute() {
		super.getPen().setStatus(1);
		return 0;
	}
	
}
