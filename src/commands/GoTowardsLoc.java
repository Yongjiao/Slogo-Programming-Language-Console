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
		double distX = x - myViewHandler.getTurtleLocation().getX();
		double distY = y - myViewHandler.getTurtleLocation().getY();
		double angle = Math.toDegrees(Math.atan2(distY, distX));
		myViewHandler.setTurtleOrientation(angle);
		return angle;
	}
}
