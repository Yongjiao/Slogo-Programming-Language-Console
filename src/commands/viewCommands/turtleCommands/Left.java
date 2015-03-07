package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

public class Left extends Rotate{
	
	public Left(ArrayList<Object> p) {
		super.setParams(p);
	}

	public double execute() {
		double angle = (Double) super.getParams().get(super.getParams().size() - 1);
		return super.changeOrientation(-angle);
	}
	
}
