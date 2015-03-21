package commands.viewCommands.turtleCommands;

import application.ViewHandler;
import javafx.geometry.Point2D;

public class ClearScreen extends TurtScreen{
	
	private ViewHandler myVH;
	
	public ClearScreen(ViewHandler vh) {
		super(vh);
		myVH = vh;
	}
	
	public double execute() {
		Point2D origLoc = myVH.getTurtleLocation();
		Point2D destination = new Point2D(0, 0);
		double dx = destination.getX() - origLoc.getX();
		double dy = destination.getY() - origLoc.getY();
		double distance = Math.sqrt((dx * dx) + (dy * dy));
		myVH.changeLocationOfTurtle(destination);
		myVH.clearScreen();
		return (int) Math.round(distance);
	}

}
