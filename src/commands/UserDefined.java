package commands;

import java.util.ArrayList;

public class UserDefined extends CommandCenter{

	private String myName;
	protected ArrayList<String> params;
	private ArrayList<CommandCenter> comms;
	
	public UserDefined(String name, ArrayList<String> p, ArrayList<CommandCenter> commands) {
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
	
	public void setParameters(ArrayList<String> p) {
		params = p;
	}
	
	public ArrayList<String> getParameters() {
		return params;
	}
	
	public void setCommands(ArrayList<CommandCenter> c){
		comms = c;
	}
	
	public ArrayList<CommandCenter> getCommands() {
		return comms;
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

}
