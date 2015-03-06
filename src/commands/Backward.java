package commands;

import java.util.ArrayList;

public class Backward extends Move{
	
	public Backward(ArrayList<Object> p) {
		params = p;
	}

	public double execute() {
		double steps = (Integer) params.get(params.size() - 1);
		return super.changeLocation(-steps);
	}
	
}
