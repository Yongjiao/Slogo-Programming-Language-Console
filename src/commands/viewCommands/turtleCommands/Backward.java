package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

public class Backward extends Move{
	
	public Backward(ArrayList<Object> p) {
		super.setParams(p);
	}

	public double execute() {
		double steps = (Integer) super.getParams().get(super.getParams().size() - 1);
		return super.changeLocation(-steps);
	}
	
}
