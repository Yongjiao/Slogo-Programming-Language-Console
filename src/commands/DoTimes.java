package commands;

import java.util.ArrayList;

import javax.activation.CommandObject;

public class DoTimes extends Loop{
	
	private int numTimes;
	private ArrayList<CommandObject> comms;
	
	public DoTimes(int m, ArrayList<CommandObject> c) {
		numTimes = m;
		comms = c;
	}
	
	public void setParams(int m, ArrayList<CommandObject> c) {
		numTimes = m;
		comms = c;
	}
	
	public void execute() {
		super.loop(0, numTimes, comms);
	}

}
