package commands.viewCommands.turtleCommands;

public class Heading extends TurtleCommands{
	
	public Heading() {
		
	}
	
	public double execute() {
		return super.getHandler().getTurtleOrientation();
	}

}
