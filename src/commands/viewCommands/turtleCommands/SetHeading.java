package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.ViewHandler;

public class SetHeading extends Rotate{
	
	public SetHeading(ArrayList<Object> p, ViewHandler v) {
		super(p, v);
	}

	public double execute() {
		double angle = (Double) super.getParams().get(super.getParams().size() - 1);
		double origOri = myViewHandler.getTurtleOrientation();
		myViewHandler.setTurtleOrientation(angle);
		return (angle - origOri);
	}
	
}
