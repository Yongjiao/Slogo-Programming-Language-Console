package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import commands.CommandCenter;

public class For extends Loop{

	public For(String localVar, int a, int b, int i, ArrayList<CommandCenter> c) {
		var = localVar;
		start = a;
		end = b;
		increment = i;
		comms = new ArrayList<CommandCenter>(c);
	}
	
	public double execute() {
		System.out.println("In For class. var = " + var);
		return super.loop(var, start, end, increment, comms);
	}

}
