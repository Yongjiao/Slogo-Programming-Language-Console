package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.CommandFactory;
import application.ViewHandler;


public abstract class Rotate extends CommandFactory{
	
	ViewHandler myViewHandler;
	protected ArrayList<Object> params;
	
	public Rotate() {
		myViewHandler = super.getViewHandler();
		super.setParams(params);
	}
	
	public double changeOrientation (double angle) {
		myViewHandler.rotateTurtle(angle);
		return angle;
	}
	
}
