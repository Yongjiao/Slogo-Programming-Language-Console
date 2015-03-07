package commands.viewCommands.turtleCommands;

import application.ViewHandler;


public abstract class Rotate extends TurtleCommands{
	
	ViewHandler myViewHandler;
	
	public Rotate() {
		myViewHandler = super.getHandler();
	}
	
	public double changeOrientation (double angle) {
		myViewHandler.rotateTurtle(angle);
		return angle;
	}
	
}
