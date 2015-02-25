package commands;

public class Forward extends Move {
	
	private int steps;

	public Forward(int s) {
		steps = s;
	}
	
	public void setParams(int s) {
		steps = s;
	}

	public void execute() {
		super.changeLocation(steps);
	}
	
}
