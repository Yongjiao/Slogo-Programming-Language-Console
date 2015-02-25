package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class IfElse extends IfConditions{
	
	private int BE;
	private ArrayList<CommandFactory> ifComms;
	private ArrayList<CommandFactory> elseComms;
	
	public IfElse(int e, ArrayList<CommandFactory> ifs, ArrayList<CommandFactory> elses){
		BE = e;
		ifComms = ifs;
		elseComms = elses;
	}
	
	public void execute() {
		super.IFELSE(BE, ifComms, elseComms);
	}
	
}
