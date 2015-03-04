package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import commands.Executable;

public class CommandFactory implements Executable{

	protected static TurtleHandler myTurtleHandler;
	private Map<String, Integer> variables = new HashMap<String, Integer>();
	private ArrayList<Object> parameters = new ArrayList<Object>();
	private ArrayList<Integer> VarLoc = new ArrayList<Integer>();
	
	public CommandFactory(){
//		parameters.add(50);
//		parameters.add(150);
//		parameters.add(250);
//		parameters.add(350);
//		parameters.add(450);
	}
	
	public void setTurtleHandler(TurtleHandler t){
		System.out.println("   in cf class - setting super handler");

		myTurtleHandler = t;
		System.out.println("   in cf class - t handler = " + t.toString());
		System.out.println("   in cf class -  th handler = " + myTurtleHandler.toString());


	}
	
	// Anika - called by commands subclasses
	protected TurtleHandler getTurtleHandler(){
		System.out.println("   in cf class - getting super handler = " + myTurtleHandler.toString());

		return myTurtleHandler;
	}

	@Override
	// each command has common method - used for loops and if statements
	// that pass to IF / LOOP commands an arraylist of command objects
	// @author anika
	public double execute() {
		return 0.0;
		// TODO make sure each command has common method - used for loops
	}
	
	public void putInMap(String str, Integer i) {
		variables.put(str, i);
	}
	
	public int checkIfInMap(String str) {
		for(int i = 0; i < variables.size(); i++) {
			if (variables.containsKey(str) == true)
				return variables.get(str);
		}
		return -1;
	}
	
	public void restore(ArrayList<Integer> l, String var) {
		for(int i : l) {
			parameters.set(i, var);
		}
	}
	
	public ArrayList<Object> getParams() {
		return parameters;
	}
	
	public void setParams(ArrayList<Object> p) {
		parameters = p;
	}
	
	public ArrayList<Integer> getVarLoc() {
		return VarLoc;
	}
	
}
