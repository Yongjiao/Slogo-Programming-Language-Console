package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class IfConditions extends CommandFactory{
	
	protected int expression;
	protected ArrayList<CommandFactory> Ifs;
	protected ArrayList<CommandFactory> Elses;
	
	public IfConditions() {
		
	}
	
	public double IFELSE(int expr, ArrayList<CommandFactory> commIf, ArrayList<CommandFactory> commElse){
		if(expr != 0){
			for(CommandFactory item : commIf) {
				return item.execute(); 
			}
		} else if (commElse != null) {
			for(CommandFactory item : commElse) {
				return item.execute();
			}
		}
		return -1;
	}
	
}
