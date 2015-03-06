package commands;

import java.util.ArrayList;

public class GoTowardsLoc extends Rotate{
	
	public GoTowardsLoc(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}

	public double execute() {
		double x = (Integer) params.get(params.size() - 2);
		double y = (Integer) params.get(params.size() - 1);
		double distX = x - myTurtleHandler.getTurtleLocation().getX();
		double distY = y - myTurtleHandler.getTurtleLocation().getY();
		double angle = Math.toDegrees(Math.atan2(distY, distX));
		myTurtleHandler.setTurtleOrientation(angle);
		return angle;
	}
}
