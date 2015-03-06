package commands;

import application.CommandFactory;
import application.TurtleHandler;

public class TurtScreen extends CommandFactory{
	
	TurtleHandler myTurtleHandler;
	
	public TurtScreen() {
		myTurtleHandler = super.getTurtleHandler();
	}

}
