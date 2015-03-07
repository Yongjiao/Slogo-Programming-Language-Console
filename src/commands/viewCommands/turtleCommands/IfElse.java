package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import commands.CommandCenter;

public class IfElse extends IfConditions{
	
	public IfElse(int e, ArrayList<CommandCenter> ifs, ArrayList<CommandCenter> elses){
		expression = e;
		Ifs = new ArrayList<CommandCenter>(ifs);
		Elses = new ArrayList<CommandCenter>(elses);
	}
	
	public double execute() {
		System.out.println("Value: " + super.IFELSE(expression, Ifs, Elses));
		return super.IFELSE(expression, Ifs, Elses);
	}
	
}
