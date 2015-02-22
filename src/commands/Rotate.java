package commands;

import application.CommandFactory;
import application.TurtleHandler;

public abstract class Rotate extends CommandFactory{
	
	TurtleHandler myTurtleHandler; // TODO: REMOVE THIS. use turtle handler from Commands Factory superclass
	
	public double changeOrientation (int angle) {
		myTurtleHandler.rotateTurtle(angle);
		return angle;
	}
	
	public double setHeading(int degrees){
		double origOri = myTurtleHandler.getTurtleOrientation();
		myTurtleHandler.setTurtleOrientation(degrees);
		return degrees - origOri;
	}
}
