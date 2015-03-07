package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import commands.UserMadeUtilities;

public class Set extends TurtleCommands {

	private String name;
	private ArrayList<Object> params;

	public Set(String s, ArrayList<Object> p) {
		name = s;
		super.setParams(p);
	}

	public double execute() {
		String var = name;
		Double val = (Double) params.get(params.size() - 1);
		UserMadeUtilities.putInVars(var, val);
		return val;
	}

}
