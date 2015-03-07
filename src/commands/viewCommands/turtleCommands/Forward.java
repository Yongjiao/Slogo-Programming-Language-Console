package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

public class Forward extends Move {

	public Forward(ArrayList<Object> p) {
		super.setParams(p);
	}

	public double execute() {
		double steps = (Double) super.getParams().get(super.getParams().size() - 1);
		return super.changeLocation(steps);
	}
}
