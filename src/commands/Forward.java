package commands;

import java.util.ArrayList;

public class Forward extends Move {

	public Forward(ArrayList<Object> p) {
		params = p;
	}

	public double execute() {
		double steps = (Integer) params.get(params.size() - 1);
		return super.changeLocation(steps);
	}
}
