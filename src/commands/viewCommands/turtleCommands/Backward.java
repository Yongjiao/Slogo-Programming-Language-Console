package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.ViewHandler;

public class Backward extends Move{
	
	public Backward(ArrayList<Object> p, ViewHandler v) {
		super(p, v);
	}

	public double execute() {
		double steps = (Double) super.getParams().get(super.getParams().size() - 1);
		return super.changeLocation(-steps);
	}
	
}
