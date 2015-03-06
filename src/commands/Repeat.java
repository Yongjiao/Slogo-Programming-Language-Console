package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class Repeat extends Loop{

	public Repeat(String v, int expr, ArrayList<CommandFactory> c) {
		var = v;
		end = expr;
		comms = c;
	}
	
	public double execute() {
		return super.loop(var, 0, end, 1, comms);
	}
	
}
