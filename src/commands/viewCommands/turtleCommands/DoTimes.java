package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.CommandFactory;

public class DoTimes extends Loop{
	
	public DoTimes(String v, int e, ArrayList<CommandFactory> c) {
		var = v;
		end = e;
		comms = c;
	}
	
	public double execute() {
		return super.loop(var, 0, end, 1, comms);
	}
}
