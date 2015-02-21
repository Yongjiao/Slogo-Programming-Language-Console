package commands;

import application.TurtleHandler;

public abstract class Rotate {
	
	TurtleHandler myTurtleHandler;
	
	public void changeOrientation (int angle) {
		myTurtleHandler.rotateTurtle(angle);
	}
	
}
