package commands;

public class PenDown extends Pen{
	
	public PenDown() {
		
	}
	
	public double execute() {
		myTurtleHandler.setPenStatus(1);
		return 1;
	}

}
