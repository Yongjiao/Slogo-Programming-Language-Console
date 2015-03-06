package commands.viewCommands.turtleCommands;

public class HideTurtle extends TurtScreen{
	
	public HideTurtle() {
		
	}
	
	public double execute() {
		myViewHandler.showTurtle(0);
		return myViewHandler.isVisible();
	}

}
