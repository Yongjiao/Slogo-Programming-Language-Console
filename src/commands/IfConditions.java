package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class IfConditions extends CommandFactory{
	
	public int IFELSE(int expr, ArrayList<CommandFactory> commIf, ArrayList<CommandFactory> commElse){
		if(expr != 0){
			for(int i = 0; i < commIf.size(); i++) {
				return commIf.get(i).execute();
			}
		} else if (commElse == null) {
			return -1;
		} else {
			for(int i = 0; i < commElse.size(); i++) {
				return commElse.get(i).execute();
			}
		}
		return -1;
	}
	
}