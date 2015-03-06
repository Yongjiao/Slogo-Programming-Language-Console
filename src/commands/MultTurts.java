package commands;

import java.util.ArrayList;

import application.CommandFactory;
import application.ViewHandler;

public class MultTurts extends CommandFactory{
	
	protected ViewHandler myTurtleHandler;
	protected ArrayList<Object> turtles;
	protected ArrayList<CommandFactory> commands;
	
	public MultTurts() {
		
	}

}
