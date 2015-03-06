package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class IfCond extends IfConditions{

	public IfCond(int e, ArrayList<CommandFactory> ifs){
		expression = e;
		Ifs = new ArrayList<CommandFactory>(ifs);
	}
	
	public double execute() {
		System.out.println("Value: " + super.IFELSE(expression, Ifs, null));
		return super.IFELSE(expression, Ifs, null);
	}
	
}
