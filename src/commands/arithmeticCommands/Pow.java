package commands.arithmeticCommands;

import java.util.ArrayList;

public class Pow extends Calculate{
	
	public Pow(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
		
	}
	
	public double execute() {
		double base = (Integer) params.get(params.size() - 2);
		double exponent = (Integer) params.get(params.size() - 1);
		return Math.pow(base, exponent);
	}
	
}
