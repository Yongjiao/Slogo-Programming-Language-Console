package commands;

import java.util.ArrayList;

public class Minus extends Calculate{
	
	public Minus(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
		
	}
	
	public double execute() {
		double num = (Double) params.get(params.size() - 1);
		return -num;
	}

}
