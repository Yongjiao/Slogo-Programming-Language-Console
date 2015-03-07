package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public class ShowTurtle extends TurtScreen{
	
	public ShowTurtle(ViewHandler v) {
		super(v);
	}
	
	public double execute() {
		super.getHandler().showTurtle(1);
		return super.getHandler().isVisible();
	}

}
