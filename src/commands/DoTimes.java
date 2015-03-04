package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class DoTimes extends Loop{
	
	private int numTimes;
	private ArrayList<CommandFactory> comms;
	
	public DoTimes(int m, ArrayList<CommandFactory> c) {
		numTimes = m;
		comms = new ArrayList<CommandFactory>(c);;
	}
	
	public void setParams(int m, ArrayList<CommandFactory> c) {
		numTimes = m;
		comms = new ArrayList<CommandFactory>(c);;
	}
	
	public int execute() {
		return super.loop(0, numTimes, 1, comms);
	}
}
