package commands;

import java.util.ArrayList;

import application.CommandFactory;
import application.TurtleHandler;

public class MultTurts extends CommandFactory{
	
	protected TurtleHandler myTurtleHandler;
	protected ArrayList<Object> turtles;
	protected ArrayList<CommandFactory> commands;
	
	public MultTurts() {
		
	}

}
