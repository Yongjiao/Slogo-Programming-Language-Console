package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import commands.CommandCenter;
import commands.arithmeticCommands.Sin;

public abstract class Loop extends TurtleCommands {
	
	protected String var;
	protected int start;
	protected int end;
	protected int increment;
	protected ArrayList<CommandCenter> comms;

	public double loop(String localVar, int a, int b, int c, ArrayList<CommandCenter> commands) {
		double lastVal = 0;
		for (int i = a; i < b; i += c) {
			for (CommandCenter comm : commands){
				ArrayList<Integer> which = new ArrayList<Integer>();
				for(Object obj : super.getParams()) {
					if(obj.equals(localVar)) {
						int index = super.getParams().indexOf(obj);
						which.add(index);
						super.getParams().set(index, i);
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
		
		ArrayList<CommandCenter> comms = new ArrayList<CommandCenter>();
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
