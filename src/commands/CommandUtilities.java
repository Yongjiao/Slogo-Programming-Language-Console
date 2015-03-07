package commands;

import application.Pen;
import application.ViewHandler;

public class CommandUtilities extends CommandCenter{
	
	private Pen myPen;
	private ViewHandler myViewHandler;
	
	
	public CommandUtilities()
	{
		
	}
	
	public void updatePenfromSuper()
	{
		myPen = super.getPen();
	}
	
	public void resetSupersPen()
	{
		super.setPen(myPen);
	}
	
	public void setInitialPen(Pen newPen)
	{
		myPen = newPen;
	}
	
	public Pen getMainPen()
	{
		return myPen;
	}
	
	public void setViewHandler(ViewHandler newVH)
	{
		myViewHandler = newVH;
	}
	
	public ViewHandler getViewHandler()
	{
		return myViewHandler;
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
