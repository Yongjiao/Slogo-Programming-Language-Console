package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class IfElse extends IfConditions{
	
	private int BE;
	private ArrayList<CommandFactory> ifComms;
	private ArrayList<CommandFactory> elseComms;
	
	public IfElse(int e, ArrayList<CommandFactory> ifs, ArrayList<CommandFactory> elses){
		BE = e;
		ifComms = new ArrayList(ifs);
		elseComms = new ArrayList(elses);
	}
	
	public int execute() {
		return super.IFELSE(BE, ifComms, elseComms);
	}
	
}
