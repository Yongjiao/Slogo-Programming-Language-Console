package commands;

import java.util.ArrayList;

import application.Pen;
import application.ViewHandler;
import commands.viewCommands.turtleCommands.Executable;

public abstract class CommandCenter implements Executable {
	
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
	
	public void restore(ArrayList<Integer> l, String s) {
		for(int i : l) {
			parameters.set(i, s);
		}
	}
	
	
}
