package commands.viewCommands;

import application.Pen;

public class PenDown extends ViewCommands{
	
	public PenDown(Pen p) {
		super(p);
	}
	
	public double execute() {
		super.getPen().setStatus(1);
		return 0;
	}

}
