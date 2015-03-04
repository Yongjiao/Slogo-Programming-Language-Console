package commands;

import java.util.ArrayList;

import application.CommandFactory;

public abstract class Calculate extends CommandFactory {

	protected ArrayList<Object> params;
	
	public Calculate() {
		super.setParams(params);
	}
	
}
