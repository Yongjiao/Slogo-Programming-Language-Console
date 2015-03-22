package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.ViewHandler;

public class SetBackground extends TurtleCommands{
	
	public SetBackground(ArrayList<Object> p, ViewHandler v) {
		super(p, v);
	}
	
	public double execute() {
		Double index = (double) super.getParams().get(super.getParams().size() - 1);
		super.getHandler().setBackground(index);
		return index;
	}

}
