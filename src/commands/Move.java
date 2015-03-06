package commands;

import java.util.ArrayList;

import javafx.geometry.Point2D;
import application.CommandFactory;
import application.ViewHandler;

public abstract class Move extends CommandFactory {
	protected ViewHandler myViewHandler;
	protected ArrayList<Object> params;

	public Move() {
		System.out.println("   in move class - getting super handler");
		myViewHandler = super.getViewHandler();
		System.out.println("   in move class -  handler = " + myViewHandler.toString());

	}

	public double changeLocation(double steps) {
		myViewHandler.moveTurtle(steps);
		return steps;
	}

	public double goToLocation(double x, double y) {
		Point2D origLoc = myViewHandler.getTurtleLocation();
		Point2D destination = new Point2D(x, y);
		double dx = destination.getX() - origLoc.getX();
		double dy = destination.getY() - origLoc.getY();
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		myViewHandler.changeLocationOfTurtle(destination);
		return distance;
	}
	
}
