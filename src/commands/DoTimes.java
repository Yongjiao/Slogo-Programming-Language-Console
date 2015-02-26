package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class DoTimes extends Loop{
	
	private int increment;
	private int numTimes;
	private ArrayList<CommandFactory> comms;
	
	public DoTimes(int m, int i, ArrayList<CommandFactory> c) {
		numTimes = m;
		increment = i;
		comms = c;
	}
	
	public void setParams(int m, ArrayList<CommandFactory> c) {
		numTimes = m;
		comms = c;
	}
	
	public int execute() {
		return super.loop(0, numTimes, increment, comms);
	}

}
