package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class DoTimes extends Loop{
	
	private int numTimes;
	private ArrayList<CommandFactory> comms;
	
	public DoTimes(int m, ArrayList<CommandFactory> c) {
		numTimes = m;
		comms = c;
	}
	
	public void setParams(int m, ArrayList<CommandFactory> c) {
		numTimes = m;
		comms = c;
	}
	
	public void execute() {
		super.loop(1, numTimes, comms);
	}

}
