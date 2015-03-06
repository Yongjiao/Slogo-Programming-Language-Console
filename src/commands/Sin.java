package commands;

import java.util.ArrayList;

public class Sin extends Calculate{
	
	public Sin(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		System.out.println("In Sin class: " + super.getParams());
		return 0;
//		double angle = (Integer) params.get(params.size() - 1);
//		return Math.sin(angle);
	}
	
}
