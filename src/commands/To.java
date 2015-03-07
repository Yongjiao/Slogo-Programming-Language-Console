package commands;

import java.util.ArrayList;

public class To extends CommandCenter{
	
	public To(String name, ArrayList<String> p, ArrayList<CommandFactory> commands) {
		UserDefined newClass = new UserDefined(name, p, commands);
		UserMadeUtilities.putInCommands(name, newClass);
	}

}
