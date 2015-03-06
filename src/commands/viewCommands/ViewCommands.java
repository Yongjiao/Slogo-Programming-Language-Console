package commands.viewCommands;

import java.util.ArrayList;

import application.Pen;
import commands.CommandCenter;

public abstract class ViewCommands extends CommandCenter{
	private static Pen myPen;
	
	
	public ViewCommands()
	{
		super.setParams(new ArrayList<Object>());
	}
	
	// initialized by Main
	public void setPen(Pen newPen)
	{
		myPen = newPen;
	}
	
	protected Pen getPen()
	{
		return myPen;
	}
	
	
}
