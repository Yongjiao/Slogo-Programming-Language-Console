package commands;

import java.util.ArrayList;

import javax.activation.CommandObject;

public class For extends Loop{
	
	private int start;
	private int end;
	private ArrayList<CommandObject> comms;
	
	public For(int a, int b, ArrayList<CommandObject> c) {
		start = a;
		end = b;
		comms = c;
	}
	
	public void setParams(int a, int b, ArrayList<CommandObject> c) {
		start = a;
		end = b;
		comms = c;
	}
	
	public void execute() {
		super.loop(start, end, comms);
	}

}
