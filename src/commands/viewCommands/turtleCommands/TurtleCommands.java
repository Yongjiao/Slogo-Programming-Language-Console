package commands.viewCommands.turtleCommands;


import java.util.ArrayList;

import commands.CommandCenter;

import application.ViewHandler;

public abstract class TurtleCommands extends CommandCenter{
	private static ViewHandler myViewHandler;
	
	public TurtleCommands()
	{
		super.setParams(new ArrayList<Object>());
		
	}
	
	// initialized by Main
	public void setViewHandler(ViewHandler newHandler)
	{
		myViewHandler = newHandler;
	}
	
	protected ViewHandler getHandler()
	{
		return myViewHandler;
	}
	
}
