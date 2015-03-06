package commands.viewCommands.turtleCommands;

import application.CommandFactory;
import application.ViewHandler;

public class TurtScreen extends CommandFactory{
	
	ViewHandler myViewHandler;
	
	public TurtScreen() {
		myViewHandler = super.getViewHandler();
	}

}
