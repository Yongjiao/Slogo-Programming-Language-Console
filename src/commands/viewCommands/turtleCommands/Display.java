package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public abstract class Display extends TurtleCommands{
	
	protected ViewHandler myTurtleHandler;
	
	public Display() {
		myTurtleHandler = super.getHandler();
		super.setParams(super.getParams());
	}

}
