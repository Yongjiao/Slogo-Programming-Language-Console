package commands.viewCommands.turtleCommands;

public class Heading extends Queries{
	
	public Heading() {
		
	}
	
	public double execute() {
		return myViewHandler.getTurtleOrientation();
	}

}
