package commands.viewCommands.turtleCommands;

public class Showing extends Queries{
	
	public Showing() {
		
	}
	
	public double execute() {
		if(myViewHandler.isVisible() == 1)
			return 1;
		return 0;
	}

}
