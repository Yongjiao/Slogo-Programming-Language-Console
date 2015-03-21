package commands.viewCommands.turtleCommands;

import javafx.geometry.Point2D;
import java.util.ArrayList;

import application.ViewHandler;

public class Towards extends Rotate{
	
	public Towards(ArrayList<Object> p, ViewHandler v) {
		super(p, v);
	}

	public double execute() {
		double origOri = myViewHandler.getTurtleOrientation();
		double x = (Double) super.getParams().get(super.getParams().size() - 2);
		double y = (Double) super.getParams().get(super.getParams().size() - 1);
		Point2D origLoc = myViewHandler.getTurtleLocation();
		double xToGo = origLoc.getX();
		double yToGo = origLoc.getY();
		
		double angleToTurn = Math.tan((xToGo - x)/(yToGo - y));
		
		myViewHandler.setTurtleOrientation(angleToTurn);
		return (angleToTurn - origOri);
	}
	
}
