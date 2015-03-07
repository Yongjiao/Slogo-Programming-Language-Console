package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

public class SetBackground extends TurtleCommands{
	
	public SetBackground(ArrayList<Object> p) {
		super.setParams(p);
	}
	
	public double execute() {
		double index = (Integer) super.getParams().get(super.getParams().size() - 1);
		super.getHandler().setBackground(index);
		return index;
	}

}
