package commands;

import java.util.ArrayList;

public class ATan extends Calculate {

	public ATan(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double angle = (Integer) params.get(params.size() - 1);
		return Math.atan(angle);
	}
}
