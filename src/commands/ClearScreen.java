package commands;

import javafx.geometry.Point2D;

public class ClearScreen extends TurtScreen{
	
	public ClearScreen() {
		
	}
	
	public double execute() {
		Point2D origLoc = myViewHandler.getTurtleLocation();
		Point2D destination = new Point2D(0, 0);
		double dx = destination.getX() - origLoc.getX();
		double dy = destination.getY() - origLoc.getY();
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		myViewHandler.changeLocationOfTurtle(destination);
		myViewHandler.clearScreen();
		return (int) Math.round(distance);
	}

}
