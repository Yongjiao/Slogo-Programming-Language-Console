package commands;

import java.util.ArrayList;

public class Sin extends Calculate{
	
	public Sin(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double angle = (Integer) params.get(params.size() - 1);
//		System.out.println(Math.sin(angle));
		return Math.sin(angle);
	}
	
}
