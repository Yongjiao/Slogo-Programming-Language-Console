package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import commands.arithmeticCommands.Sin;

import application.CommandFactory;

public abstract class Loop extends TurtleCommands {
	
	protected String var;
	protected int start;
	protected int end;
	protected int increment;
	protected ArrayList<CommandFactory> comms;

	public double loop(String localVar, int a, int b, int c, ArrayList<CommandFactory> commands) {
		double lastVal = 0;
		for (int i = a; i < b; i += c) {
			for (CommandFactory comm : commands){
				ArrayList<Integer> which = new ArrayList<Integer>();
				for(Object obj : comm.getParams()) {
					if(obj.equals(localVar)) {
						int index = comm.getParams().indexOf(obj);
						which.add(index);
						comm.getParams().set(index, i);
					}
				}
				lastVal = comm.execute();
				comm.restore(which, localVar);
			}
		}
		System.out.println("This is the last value: " + lastVal);
		return lastVal;
	}
	
	public static void main(String[] args) {
		//for testing
		
		ArrayList<CommandFactory> comms = new ArrayList<CommandFactory>();
		ArrayList<Object> a = new ArrayList<Object>();
		a.add(0);
		ArrayList<Object> b = new ArrayList<Object>();
		b.add("s");
		Sin f = new Sin(a);
		Sin d = new Sin(b);
		comms.add(f);
		comms.add(d);
		
		For fr = new For("s", 0, 360, 60, comms);
		fr.execute();
		
	}

}
