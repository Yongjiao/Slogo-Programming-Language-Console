package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.ViewHandler;

public class GoTowardsLoc extends Rotate{
	
	public GoTowardsLoc(ArrayList<Object> p, ViewHandler v) {
		super(p, v);
	}

	public double execute() {
		double x = (Double) super.getParams().get(super.getParams().size() - 2);
		double y = (Double) super.getParams().get(super.getParams().size() - 1);
		double distX = x - myViewHandler.getTurtleLocation().getX();
		double distY = y - myViewHandler.getTurtleLocation().getY();
		double angle = Math.toDegrees(Math.atan2(distY, distX));
		myViewHandler.setTurtleOrientation(angle);
		return angle;
	}
}
