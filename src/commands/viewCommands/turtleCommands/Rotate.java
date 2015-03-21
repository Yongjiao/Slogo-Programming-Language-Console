package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.ViewHandler;


public abstract class Rotate extends TurtleCommands{
	
	ViewHandler myViewHandler;
	
	public Rotate(ArrayList<Object> p, ViewHandler vh) {
		super(p, vh);
		myViewHandler = vh;
	}
	
	public double changeOrientation (double angle) {
		myViewHandler.rotateTurtle(angle);
		return angle;
	}
	
}
