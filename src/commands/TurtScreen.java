package commands;

import javafx.geometry.Point2D;
import application.CommandFactory;
import application.TurtleHandler;

public class TurtScreen extends CommandFactory{
	
	TurtleHandler myTurtleHandler;
	
	public TurtScreen() {
		myTurtleHandler = super.getTurtleHandler();
	}
	
	public int clear() {
		Point2D origLoc = myTurtleHandler.getTurtleLocation();
		Point2D destination = new Point2D(0, 0);
		double dx = destination.getX() - origLoc.getX();
		double dy = destination.getY() - origLoc.getY();
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		myTurtleHandler.changeLocationOfTurtle(destination);
		myTurtleHandler.clearScreen();
		return (int) Math.round(distance);
	}
	
	public int show() {
		myTurtleHandler.showTurtle(1);
		return myTurtleHandler.isVisible();
	}
	
	public int hide() {
		myTurtleHandler.showTurtle(0);
		return myTurtleHandler.isVisible();
	}

}
