package commands;

public class YCor extends Queries{
	
	public YCor() {
		
	}
	
	public double execute() {
		return myViewHandler.getTurtleLocation().getY();
	}

}
