package commands;

import java.util.ArrayList;

import application.Pen;
import application.ViewHandler;
import commands.viewCommands.turtleCommands.Executable;

public abstract class CommandCenter implements Executable {
	private Pen temporaryPen;
	private ViewHandler temporaryViewHandler;
	
	private ArrayList<Object> parameters;
	
	public CommandCenter(){
		
	}
	
	protected void setParams(ArrayList<Object> newParams)
	{
		parameters = newParams;
	}
	
	protected ArrayList<Object> getParams()
	{
		return parameters;
	}
	
	protected Pen getPen()
	{
		return temporaryPen;
	}
	
	protected void setPen(Pen penToSet)
	{
		temporaryPen = penToSet;
	}
	
}
