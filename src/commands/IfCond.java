package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class IfCond extends IfConditions{
	
	private int BE;
	private ArrayList<CommandFactory> comms;

	public IfCond(int e, ArrayList<CommandFactory> ifs){
		BE = e;
		comms = ifs;
	}
	
	public void execute() {
		super.IFELSE(BE, comms, null);
	}
	
}
