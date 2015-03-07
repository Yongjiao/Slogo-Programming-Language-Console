package commands;

import java.util.ArrayList;

public class To extends CommandCenter{
	
	public To(String name, ArrayList<String> p, ArrayList<CommandCenter> commands) {
		UserDefined newClass = new UserDefined(name, p, commands);
		UserMadeUtilities.putInCommands(name, newClass);
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

}
