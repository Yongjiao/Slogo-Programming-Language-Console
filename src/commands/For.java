package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class For extends Loop{
	
	private int start;
	private int end;
	private int increment;
	private ArrayList<CommandFactory> comms;
	
	public For(int a, int b, int i, ArrayList<CommandFactory> c) {
		start = a;
		end = b;
		increment = i;
		comms = c;
	}
	
	public void setParams(int a, int b, ArrayList<CommandFactory> c) {
		start = a;
		end = b;
		comms = c;
	}
	
	public int execute() {
		return super.loop(start, end, increment, comms);
	}

}
