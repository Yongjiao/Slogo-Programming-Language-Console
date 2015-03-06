package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import commands.viewCommands.turtleCommands.Executable;

public class CommandFactory implements Executable{

	protected static ViewHandler myViewHandler;
	public static Map<String, Double> variables = new HashMap<String, Double>();
	private ArrayList<Object> parameters = new ArrayList<Object>();
	private ArrayList<Integer> VarLoc = new ArrayList<Integer>();
	
	public CommandFactory(){
	}
	
	public void setViewHandler(ViewHandler t){
		System.out.println("   in cf class - setting super handler");

		myViewHandler = t;
		System.out.println("   in cf class - t handler = " + t.toString());
		System.out.println("   in cf class -  th handler = " + myViewHandler.toString());


	}
	
	// Anika - called by commands subclasses
	protected ViewHandler getViewHandler(){
		System.out.println("   in cf class - getting super handler = " + myViewHandler.toString());

		return myViewHandler;
	}

	@Override
	// each command has common method - used for loops and if statements
	// that pass to IF / LOOP commands an arraylist of command objects
	// @author anika
	public double execute() {
		// TODO make sure each command has common method - used for loops
		return 0;
	}
	
	public void putInMap(String str, double i) {
		variables.put(str, i);
	}
	
	public Object checkIfInMap(String str) {
		for(int i = 0; i < variables.size(); i++) {
			if (variables.containsKey(str) == true){
				parameters.add(variables.get(str));
				Object p = parameters.get(parameters.size() - 1);
				return p;
			}
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
	
	public Map<String, Double> getVars() {
		return variables;
	}
	
}