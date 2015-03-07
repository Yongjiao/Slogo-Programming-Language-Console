package commands.viewCommands;

import java.util.ArrayList;

import application.Pen;
import commands.CommandCenter;

public class ViewCommands extends CommandCenter{
	private static Pen myPen;
	private ArrayList<Object> params;
	
	
	public ViewCommands(Pen p)
	{
		myPen = p;
		super.setParams(new ArrayList<Object>());
	}
	
	public ViewCommands(ArrayList<Object> l, Pen p)
	{
		params = l;
		myPen = p;
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

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
