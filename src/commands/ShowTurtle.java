package commands;

public class ShowTurtle extends TurtScreen{
	
	public ShowTurtle() {
		
	}
	
	public double execute() {
		myTurtleHandler.showTurtle(1);
		return myTurtleHandler.isVisible();
	}

}
