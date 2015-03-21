package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public abstract class TurtScreen extends TurtleCommands{
	
	ViewHandler myViewHandler;
	
	public TurtScreen(ViewHandler v) {
		super(v);
		myViewHandler = v;
	}

}
