package commands;

import java.util.ArrayList;

public class SetHeading extends Rotate{
	
	public SetHeading(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}

	public double execute() {
		double angle = (Integer) params.get(params.size() - 1);
		double origOri = myTurtleHandler.getTurtleOrientation();
		myTurtleHandler.setTurtleOrientation(angle);
		return (angle - origOri);
	}
	
}
