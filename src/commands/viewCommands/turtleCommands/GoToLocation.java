package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.ViewHandler;


public class GoToLocation extends Move {

	public GoToLocation(ArrayList<Object> p, ViewHandler v) {
		super(p, v);
	}

	public double execute() {
		double x = (Double) super.getParams().get(super.getParams().size() - 2);
		double y = (Double) super.getParams().get(super.getParams().size() - 1);
		return super.goToLocation(x, y);
	}
}
