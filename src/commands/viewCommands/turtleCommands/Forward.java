package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.ViewHandler;

public class Forward extends Move {

	public Forward(ArrayList<Object> p, ViewHandler v) {
		super(p, v);
	}

	public double execute() {
		double steps = (Double) this.getParams().get(this.getParams().size() - 1);
		return super.changeLocation(steps);
	}
}
