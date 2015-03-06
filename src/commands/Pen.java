package commands;

import application.CommandFactory;
import application.TurtleHandler;

public class Pen extends CommandFactory{
	
	TurtleHandler myTurtleHandler;
	
	public Pen() {
		myTurtleHandler = super.getTurtleHandler();
	}
	
}
