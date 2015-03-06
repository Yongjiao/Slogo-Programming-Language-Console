package commands.arithmeticCommands;

import java.util.ArrayList;

import commands.CommandCenter;
import application.CommandFactory;

/**
 * Superclass for basic arithmetic subclasses to extend.
 * 
 * @author TheSweatshopKid
 *
 */

public abstract class Arithmetic extends CommandCenter {
	
	protected ArrayList<Object> params;
	
	public Arithmetic() {
		//super.setParams(params);
	}
	
	public void setParams(ArrayList<Object> newParams)
	{
		params = newParams;
	}
	
}