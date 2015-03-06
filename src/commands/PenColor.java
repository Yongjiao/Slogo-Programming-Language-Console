package commands;

public class PenColor extends Display{
	
	public PenColor() {
		
	}
	
	public double execute() {
		return super.myTurtleHandler.getPenColor();
	}

}
