package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import commands.CommandCenter;
import application.ViewHandler;

public class TurtleCommands extends CommandCenter{
	private ViewHandler myViewHandler;
	private ArrayList<Object> params;
	
	public TurtleCommands() {
		
	}
	
	public TurtleCommands(ViewHandler v)
	{
		myViewHandler = v;
		super.setParams(new ArrayList<Object>());
		
	}
	
	public TurtleCommands(ArrayList<Object> p, ViewHandler v)
	{
		params = p;
		myViewHandler = v;
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

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	protected void setParams(ArrayList<Object> newParams)
	{
		super.setParams(newParams);
	}
	
	protected ArrayList<Object> getParams()
	{
		return super.getParams();
	}
	
}
