package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import commands.CommandCenter;

public abstract class IfConditions extends TurtleCommands{
	
	protected int expression;
	protected ArrayList<CommandCenter> Ifs;
	protected ArrayList<CommandCenter> Elses;
	
	public IfConditions() {
		
	}
	
	public double IFELSE(int expr, ArrayList<CommandCenter> commIf, ArrayList<CommandCenter> commElse){
		if(expr != 0){
			for(CommandCenter item : commIf) {
				return item.execute(); 
			}
		} else if (commElse != null) {
			for(CommandCenter item : commElse) {
				return item.execute();
			}
		}
		return -1;
	}
	
}
