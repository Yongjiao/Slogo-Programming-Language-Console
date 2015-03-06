package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class IfElse extends IfConditions{
	
	public IfElse(int e, ArrayList<CommandFactory> ifs, ArrayList<CommandFactory> elses){
		expression = e;
		Ifs = new ArrayList<CommandFactory>(ifs);
		Elses = new ArrayList<CommandFactory>(elses);
	}
	
	public double execute() {
		System.out.println("Value: " + super.IFELSE(expression, Ifs, Elses));
		return super.IFELSE(expression, Ifs, Elses);
	}
	
}
