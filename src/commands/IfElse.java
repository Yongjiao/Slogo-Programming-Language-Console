package commands;

import java.util.ArrayList;

import javax.activation.CommandObject;

public class IfElse extends IfConditions{
	
	private int BE;
	private ArrayList<CommandObject> ifComms;
	private ArrayList<CommandObject> elseComms;
	
	public IfElse(int e, ArrayList<CommandObject> ifs, ArrayList<CommandObject> elses){
		BE = e;
		ifComms = ifs;
		elseComms = elses;
	}
	
	public void execute() {
		super.IFELSE(BE, ifComms, elseComms);
	}
	
}
