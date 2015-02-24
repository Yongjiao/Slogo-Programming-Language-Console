package commands;

import application.CommandFactory;

public class Make extends CommandFactory{
	
	public void execute(String name, int value){
		vars.put(name, value);
	}

}
