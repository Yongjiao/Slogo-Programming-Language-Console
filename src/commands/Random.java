package commands;

import java.util.ArrayList;

public class Random extends Calculate{

	private int max;
	
	public Random(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		return Math.random() * max;
	}
	
}
