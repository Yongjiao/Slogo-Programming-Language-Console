package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public class Showing extends TurtleCommands{
	
	public Showing(ViewHandler v) {
		super(v);
	}
	
	public double execute() {
		if(super.getHandler().isVisible() == 1)
			return 1;
		return 0;
	}

}
