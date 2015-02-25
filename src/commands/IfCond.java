package commands;

import java.util.ArrayList;

import javax.activation.CommandObject;

public class IfCond extends IfConditions{
	
	private int BE;
	private ArrayList<CommandObject> comms;

	public IfCond(int e, ArrayList<CommandObject> ifs){
		BE = e;
		comms = ifs;
	}
	
	public void execute() {
		super.IFELSE(BE, comms, null);
	}
	
}
