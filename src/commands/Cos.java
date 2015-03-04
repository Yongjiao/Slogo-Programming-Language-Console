package commands;

import java.util.ArrayList;

public class Cos extends Calculate{

	private int angle;
	
	public Cos(int a) {
		ArrayList<Integer> l = super.getParams();
		angle = l.get(l.size() - 1);
	}
	
	public int execute() {
		return (int) Math.round(Math.cos(angle));
	}
	
}
