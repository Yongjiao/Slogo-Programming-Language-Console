package commands;

import application.CommandFactory;
import application.TurtleHandler;


public abstract class Rotate extends CommandFactory{
	
	TurtleHandler myTurtleHandler = super.getTurtleHandler();
	
	
	public double changeOrientation (int angle) {
		myTurtleHandler.rotateTurtle(angle);
		return angle;
	}

	public double setHeading(int degrees) {
		double origOri = myTurtleHandler.getTurtleOrientation();
		myTurtleHandler.setTurtleOrientation(degrees);
		return degrees - origOri;
	}

	public double goTowardsLoc(int x, int y){
		double distX = x - myTurtleHandler.getTurtleLocation().getX();
		double distY = y - myTurtleHandler.getTurtleLocation().getY();
		double angle = (int)Math.toDegrees(Math.atan2(distY, distX));
		myTurtleHandler.setTurtleOrientation(angle);
		return angle;
	}
	
}
