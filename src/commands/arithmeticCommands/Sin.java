package commands.arithmeticCommands;

import java.util.ArrayList;

public class Sin extends Calculate{
	
	public Sin(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double angle = (Double) params.get(params.size() - 1);
		return Math.sin(angle);
	}
	
}
