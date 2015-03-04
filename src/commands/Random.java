package commands;

import java.util.ArrayList;

public class Random extends Calculate{

	private int max;
	
	public Random(int a) {
		ArrayList<Integer> l = super.getParams();
		max = l.get(l.size() - 1);
	}
	
	public int execute() {
		double r = Math.random() * max;
		return (int) Math.round(r);
	}
	
}
