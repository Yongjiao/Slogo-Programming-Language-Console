package commands;

import application.CommandFactory;
import application.TurtleHandler;

public class Queries extends CommandFactory{
	
	protected TurtleHandler myTurtleHandler;
	
	public Queries() {
		myTurtleHandler = super.getTurtleHandler();
	}

}
