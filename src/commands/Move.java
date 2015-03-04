package commands;

import java.util.ArrayList;

import javafx.geometry.Point2D;
import application.CommandFactory;
import application.TurtleHandler;

public abstract class Move extends CommandFactory {
	protected TurtleHandler myTurtleHandler;
	protected ArrayList<Object> params;
	
	public Move() {
		System.out.println("   in move class - getting super handler");
		myTurtleHandler = super.getTurtleHandler();
		System.out.println("   in move class -  handler = " + myTurtleHandler.toString());

	}

	public double changeLocation(double steps) {
		myTurtleHandler.moveTurtle(steps);
		return steps;
	}

	public int GoToLocation(int x, int y) {
		Point2D origLoc = myTurtleHandler.getTurtleLocation();
		Point2D destination = new Point2D(x, y);
		double dx = destination.getX() - origLoc.getX();
		double dy = destination.getY() - origLoc.getY();
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		myTurtleHandler.changeLocationOfTurtle(destination);
		return (int) distance;
	}
}
