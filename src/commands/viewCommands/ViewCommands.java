package commands.viewCommands;

import java.util.ArrayList;

import application.Pen;
import application.PenHandler;
import commands.CommandCenter;

public class ViewCommands extends CommandCenter{
	private PenHandler myPH;
	private ArrayList<Object> params;
	
	public ViewCommands() {
		
	}
	
	public ViewCommands(PenHandler p)
	{
		myPH = p;
		super.setParams(new ArrayList<Object>());
	}
	
	public ViewCommands(ArrayList<Object> l, PenHandler p)
	{
		params = l;
		myPH = p;
		super.setParams(new ArrayList<Object>());
	}
	
	// initialized by Main
	public void setPenHandler(PenHandler newPen)
	{
		myPH = newPen;
	}
	
	protected PenHandler getPenHandler()
	{
		return myPH;
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
