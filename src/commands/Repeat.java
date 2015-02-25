package commands;

import java.util.ArrayList;

import javax.activation.CommandObject;

public class Repeat extends Loop{

	private int numTimes;
	private ArrayList<CommandObject> comms;
	
	public Repeat(int b, ArrayList<CommandObject> c) {
		numTimes = b;
		comms = c;
	}
	
	public void setParams(int b, ArrayList<CommandObject> c) {
		numTimes = b;
		comms = c;
	}
	
	public void execute(){
		super.loop(0, numTimes, comms);
	}
	
}
