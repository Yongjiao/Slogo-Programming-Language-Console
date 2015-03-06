package commands;

import java.util.ArrayList;

import application.CommandFactory;

/**
 * Superclass for basic arithmetic subclasses to extend.
 * 
 * @author TheSweatshopKid
 *
 */

public abstract class Arithmetic extends CommandFactory{
	
	protected ArrayList<Object> params;
	
	public Arithmetic() {
		super.setParams(params);
	}
	
}