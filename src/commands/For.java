package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class For extends Loop{
	
	private int start;
	private int end;
	private int inc;
	private ArrayList<CommandFactory> comms;

	
	public For(int a, int b, int c, ArrayList<CommandFactory> d) {
		start = a;
		end = b;
		inc = c;
		comms = d;
	}
	
	public void setParams(int a, int b, int c, ArrayList<CommandFactory> d) {
		start = a;
		end = b;
		inc = c;
		comms = d;
	}
	
	public void execute() {
		super.loop(start, end, comms);
	}

}
