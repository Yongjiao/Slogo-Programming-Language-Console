package commands;

import application.TurtleHandler;

public abstract class Rotate {
	
	TurtleHandler myTurtleHandler;
	
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
