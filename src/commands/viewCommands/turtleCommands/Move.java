package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import javafx.geometry.Point2D;
import application.ViewHandler;

public abstract class Move extends TurtleCommands{
	protected ViewHandler myViewHandler;
	protected ArrayList<Object> params;

	public Move(ViewHandler vh) {
		super(vh);
		myViewHandler = vh;
	}
	
	public Move(ArrayList<Object> p, ViewHandler vh) {
		super(p, vh);
		myViewHandler = vh;
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
