package commands;

import application.CommandFactory;
import application.TurtleHandler;

public class Pen extends CommandFactory{
	
	TurtleHandler myTurtleHandler;
	
	public Pen() {
		myTurtleHandler = super.getTurtleHandler();
	}
	
	public int penDown() {
		myTurtleHandler.setPenStatus(1);
		return 1;
	}
	
	public int penUp() {
		myTurtleHandler.setPenStatus(0);
		return 0;
	}

}
