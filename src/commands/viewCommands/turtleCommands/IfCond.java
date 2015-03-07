package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import commands.CommandCenter;

public class IfCond extends IfConditions{

	public IfCond(int e, ArrayList<CommandCenter> ifs){
		expression = e;
		Ifs = new ArrayList<CommandCenter>(ifs);
	}
	
	public double execute() {
		System.out.println("Value: " + super.IFELSE(expression, Ifs, null));
		return super.IFELSE(expression, Ifs, null);
	}
	
}
