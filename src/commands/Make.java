package commands;

import application.CommandFactory;

public class Make extends CommandFactory{
	
	public void execute(String name, int value){
		super.putInMap(name, value);
	}

}
