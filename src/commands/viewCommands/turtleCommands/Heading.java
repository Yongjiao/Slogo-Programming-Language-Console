package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public class Heading extends TurtleCommands{
	
	public Heading(ViewHandler v) {
		super(v);
	}
	
	public double execute() {
		return super.getHandler().getTurtleOrientation();
	}

}
