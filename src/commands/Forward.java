package commands;

import configuration.Parser;

public class Forward extends Move {
	
	private int steps;

	public Forward(int s) {
		steps = s;
	}
	
	public void setParams(int s) {
		steps = s;
	}

	public int execute() {
		return super.changeLocation(steps);
	}
}
