package commands;

import java.util.ArrayList;

public class UserDefined{

	private String myName;
	protected ArrayList<String> params;
	private ArrayList<CommandFactory> comms;
	
	public UserDefined(String name, ArrayList<String> p, ArrayList<CommandFactory> commands) {
		myName = name;
		params = p;
		comms = commands;
	}
	
	public UserDefined makeInstanceOfSelf() {
		UserDefined newUD = new UserDefined(myName, params, comms);
		return newUD;
	}
	
	public void setName(String n) {
		myName = n;
	}
	
	public String getName() {
		return myName;
	}
	
	public void setParams(ArrayList<String> p) {
		params = p;
	}
	
	public ArrayList<String> getParams() {
		return params;
	}
	
	public void setCommands(ArrayList<CommandFactory> c){
		comms = c;
	}
	
	public ArrayList<CommandFactory> getCommands() {
		return comms;
	}

}
