package commands.viewCommands.turtleCommands;

public class Showing extends TurtleCommands{
	
	public Showing() {
		
	}
	
	public double execute() {
		if(super.getHandler().isVisible() == 1)
			return 1;
		return 0;
	}

}
