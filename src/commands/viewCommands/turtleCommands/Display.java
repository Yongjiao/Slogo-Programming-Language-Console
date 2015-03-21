package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public abstract class Display extends TurtleCommands{
	
	protected ViewHandler myViewHandler;
	
	public Display(ViewHandler vh) {
		super(vh);
		super.setParams(super.getParams());
		myViewHandler = vh;
	}

}
