package commands;

import javafx.geometry.Point2D;
import application.TurtleHandler;

public abstract class Move {
	TurtleHandler myTurtleHandler;

	public double changeLocation(int steps) {
		myTurtleHandler.moveTurtle(steps);
		return steps;
	}

	public double GoToLocation(int x, int y) {
		Point2D origLoc = myTurtleHandler.getTurtleLocation();
		Point2D destination = new Point2D(x, y);
		double dx = destination.getX() - origLoc.getX();
		double dy = destination.getY() - origLoc.getY();
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		myTurtleHandler.changeLocationOfTurtle(destination);
		return distance;
	}
}
