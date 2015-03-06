package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class To extends CommandFactory{
	
	public To(String name, ArrayList<String> p, ArrayList<CommandFactory> commands) {
		UserDefined newClass = new UserDefined(name, p, commands);
		UserMadeUtilities.putInCommands(name, newClass);
	}

}
