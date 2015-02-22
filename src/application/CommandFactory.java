package application;

public class CommandFactory {

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
	
}
