package application;

import commands.Executable;

public class CommandFactory implements Executable{

	protected TurtleHandler myTurtleHandler;
	
	public CommandFactory(){
		
	}
	
	public void setTurtleHandler(TurtleHandler t){
		myTurtleHandler = t;
	}
	
	// Anika - called by commands subclasses
	protected TurtleHandler getTurtleHandler(){
		return myTurtleHandler;
	}

	@Override
	// each command has common method - used for loops and if statements
	// that pass to IF / LOOP commands an arraylist of command objects
	// @author anika
	public int execute() {
		// TODO make sure each command has common method - used for loops
		
	}
	
}
