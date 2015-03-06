package commands;

public class HideTurtle extends TurtScreen{
	
	public HideTurtle() {
		
	}
	
	public double execute() {
		myTurtleHandler.showTurtle(0);
		return myTurtleHandler.isVisible();
	}

}
