package commands;

import application.TurtleHandler;

public abstract class Move {
	TurtleHandler myTurtleHandler;
	
	public void changeLocation(int steps){
		myTurtleHandler.moveTurtle(steps);
	}
	
}
