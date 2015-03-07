package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.ViewHandler;

public class Right extends Rotate{
	
	public Right(ArrayList<Object> p, ViewHandler v) {
		super(p, v);
	}

	public double execute() {
		double angle = (Double) super.getParams().get(super.getParams().size() - 1);
		return super.changeOrientation(angle);
	}
	
}
