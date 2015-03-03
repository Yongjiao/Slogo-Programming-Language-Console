package commands;

import application.CommandFactory;
import application.TurtleHandler;

public class Queries extends CommandFactory{
	
	TurtleHandler myTurtleHandler;
	
	public Queries() {
		myTurtleHandler = super.getTurtleHandler();
	}
	
	public int xCor() {
		return (int)myTurtleHandler.getTurtleLocation().getX();
	}
	
	public int yCor() {
		return (int)myTurtleHandler.getTurtleLocation().getY();
	}
	
	public int heading() {
		return (int)myTurtleHandler.getTurtleOrientation();
	}
	
	public int isPenDown() {
		if(myTurtleHandler.getPenStatus() == 1)
			return 1;
		return 0;
	}
	
	public int isShowing() {
		if(myTurtleHandler.isVisible() == 1)
			return 1;
		return 0;
	}

}
