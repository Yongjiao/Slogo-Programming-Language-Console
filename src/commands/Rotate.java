package commands;

import java.util.ArrayList;

import application.CommandFactory;
import application.TurtleHandler;


public abstract class Rotate extends CommandFactory{
	
	TurtleHandler myTurtleHandler;
	protected ArrayList<Object> params;
	
	public Rotate() {
		myTurtleHandler = super.getTurtleHandler();
		super.setParams(params);
	}
	
	public double changeOrientation (double angle) {
		myTurtleHandler.rotateTurtle(angle);
		return angle;
	}
	
}
