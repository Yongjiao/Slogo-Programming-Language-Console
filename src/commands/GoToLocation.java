package commands;

import java.util.ArrayList;


public class GoToLocation extends Move {

	public GoToLocation(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}

	public double execute() {
		double x = (Integer) params.get(params.size() - 2);
		double y = (Integer) params.get(params.size() - 1);
		return super.goToLocation(x, y);
	}

}
