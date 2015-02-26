package commands;

import application.CommandFactory;
import application.TurtleHandler;


public abstract class Rotate extends CommandFactory{
	
	TurtleHandler myTurtleHandler;
	
	public Rotate() {
		myTurtleHandler = super.getTurtleHandler();
	}
	
	public int changeOrientation (int angle) {
		myTurtleHandler.rotateTurtle(angle);
		return (int) Math.round(angle);
	}

	public int setHeading(int degrees) {
		double origOri = myTurtleHandler.getTurtleOrientation();
		myTurtleHandler.setTurtleOrientation(degrees);
		return (int) Math.round(degrees - origOri);
	}

	public int goTowardsLoc(int x, int y){
		double distX = x - myTurtleHandler.getTurtleLocation().getX();
		double distY = y - myTurtleHandler.getTurtleLocation().getY();
		double angle = (int)Math.toDegrees(Math.atan2(distY, distX));
		myTurtleHandler.setTurtleOrientation(angle);
		return (int) Math.round(angle);
	}
	
}
