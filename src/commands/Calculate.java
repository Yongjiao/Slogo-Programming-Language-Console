package commands;

import java.util.ArrayList;

import application.CommandFactory;

public abstract class Calculate extends CommandFactory {

	protected ArrayList<Object> params;
	
	public Calculate() {
		super.setParams(params);
	}
	
	public void setCFParams() {
		super.setParams(params);
	}
	
	public static void main (String[] arg) {
		//CommandFactory cf = new CommandFactory();
		String angle = "Angle";
		//cf.putInMap(angle, 50);
		ArrayList<Object> l = new ArrayList<Object>();
		l.add(angle);
		Sin s = new Sin(l);
		System.out.println(variables);
		s.execute();
	}
	
}
