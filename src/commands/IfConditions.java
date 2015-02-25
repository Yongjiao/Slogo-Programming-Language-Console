package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class IfConditions extends CommandFactory{
	
	public void IFELSE(int expr, ArrayList<CommandFactory> commIf, ArrayList<CommandFactory> commElse){
		if(expr != 0){
			for(int i = 0; i < commIf.size(); i++) {
				commIf.get(i).execute();
			}
		} else {
			for(int i = 0; i < commElse.size(); i++) {
				commElse.get(i).execute();
			}
		}
	}
	
}
