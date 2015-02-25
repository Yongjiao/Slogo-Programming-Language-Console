package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class Repeat extends Loop{

	private int numTimes;
	private ArrayList<CommandFactory> comms;
	
	public Repeat(int b, ArrayList<CommandFactory> c) {
		numTimes = b;
		comms = c;
	}
	
	public void setParams(int b, ArrayList<CommandFactory> c) {
		numTimes = b;
		comms = c;
	}
	
	public void execute(){
		super.loop(0, numTimes, comms);
	}
	
}
