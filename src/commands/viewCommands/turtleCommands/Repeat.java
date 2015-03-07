package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import commands.CommandCenter;

public class Repeat extends Loop{

	public Repeat(String v, int expr, ArrayList<CommandCenter> c) {
		var = v;
		end = expr;
		comms = c;
	}
	
	public double execute() {
		return super.loop(var, 0, end, 1, comms);
	}
	
}
