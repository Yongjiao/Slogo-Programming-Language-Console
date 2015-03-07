package commands.viewCommands.turtleCommands;

import java.util.ArrayList;


public class GoToLocation extends Move {

	public GoToLocation(ArrayList<Object> p) {
		super.setParams(p);
	}

	public double execute() {
		double x = (Integer) super.getParams().get(super.getParams().size() - 2);
		double y = (Integer) super.getParams().get(super.getParams().size() - 1);
		return super.goToLocation(x, y);
	}

}
