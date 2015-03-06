package commands;

public class PenUp extends Pen{
	
	public PenUp() {
		
	}
	
	public double execute() {
		myViewHandler.setPenStatus(0);
		return 0;
	}
	
}
