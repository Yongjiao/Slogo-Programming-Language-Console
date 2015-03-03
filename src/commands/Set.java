package commands;

import application.CommandFactory;

public class Set extends CommandFactory{
	
	private String var;
	private int val;

	public Set(String s, int i) {
		var = s; val = i;
	}
	
	public int execute() {
		putInMap(var, val);
		return val;
	}
	
}
