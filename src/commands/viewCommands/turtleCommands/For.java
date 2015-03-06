package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.CommandFactory;

public class For extends Loop{

	public For(String localVar, int a, int b, int i, ArrayList<CommandFactory> c) {
		var = localVar;
		start = a;
		end = b;
		increment = i;
		comms = new ArrayList<CommandFactory>(c);
	}
	
	public double execute() {
		System.out.println("In For class. var = " + var);
		return super.loop(var, start, end, increment, comms);
	}

}
