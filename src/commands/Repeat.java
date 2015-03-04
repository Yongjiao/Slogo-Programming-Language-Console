package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class Repeat extends Loop{

	private int numTimes;
	private ArrayList<CommandFactory> comms;
	
	public Repeat(int b, ArrayList<CommandFactory> c) {
		numTimes = b;
		comms = new ArrayList<CommandFactory>(c);;
	}
	
	public void setParams(int b, ArrayList<CommandFactory> c) {
		numTimes = b;
		comms = new ArrayList<CommandFactory>(c);;
	}
	
	public int execute(){
		return super.loop(0, numTimes, 1, comms);
	}
	
}
