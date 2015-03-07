package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public class HideTurtle extends TurtScreen{
	
	public HideTurtle(ViewHandler v) {
		super(v);
	}
	
	public double execute() {
		super.getHandler().showTurtle(0);
		return super.getHandler().isVisible();
	}

}
