package commands.arithmeticCommands;

import java.util.ArrayList;

import commands.CommandCenter;

public abstract class Compare extends CommandCenter{
	
protected ArrayList<Object> params;
	
	public Compare() {
		
	}
	
	public void setParams(ArrayList<Object> newParams)
	{
		params = newParams;
	}
}
