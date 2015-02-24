package commands;

import java.util.HashMap;
import java.util.Map;

import application.CommandFactory;

public class SetVariable extends CommandFactory{
	
	Map<String, Integer> variables = new HashMap<String, Integer>();
	
	public SetVariable(String name, int value){
		variables.put(name, value);
	}

}
