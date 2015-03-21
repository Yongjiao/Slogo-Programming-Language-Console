package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.ViewHandler;

public class Forward extends Move {

	public Forward(ArrayList<Object> p, ViewHandler v) {
		super(p, v);
	}

	public double execute() {
		System.out.println("Parameters size is " + super.getParams().size());
		System.out.println("the Parameters are " + super.getParams() );
		double steps = (Double) super.getParams().get(super.getParams().size() - 1);
		return super.changeLocation(steps);
	}
}
