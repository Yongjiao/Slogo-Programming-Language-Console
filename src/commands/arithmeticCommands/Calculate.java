package commands.arithmeticCommands;

import java.util.ArrayList;

import commands.CommandCenter;

public abstract class Calculate extends CommandCenter {

	protected ArrayList<Object> params;
	
	public Calculate() {
		super.setParams(params);
	}
	
	public void setCFParams() {
		super.setParams(params);
	}
	
}
