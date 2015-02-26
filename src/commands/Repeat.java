package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class Repeat extends Loop{

	private int numTimes;
	private int increment;
	private ArrayList<CommandFactory> comms;
	
	public Repeat(int b, int i, ArrayList<CommandFactory> c) {
		numTimes = b;
		increment = i;
		comms = c;
	}
	
	public void setParams(int b, ArrayList<CommandFactory> c) {
		numTimes = b;
		comms = c;
	}
	
	public int execute(){
		return super.loop(0, numTimes, increment, comms);
	}
	
}
