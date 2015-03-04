package commands;

import java.util.ArrayList;

public class Pow extends Calculate{

	private int base;
	private int exponent;
	
	public Pow(int a, int b) {
		ArrayList<Integer> l = super.getParams();
		base = l.get(l.size() - 2);
		exponent = l.get(l.size() - 1);
	}
	
	public int execute() {
		return (int) Math.pow(base, exponent);
	}
	
}
