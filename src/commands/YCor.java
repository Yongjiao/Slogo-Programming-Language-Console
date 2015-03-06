package commands;

public class YCor extends Queries{
	
	public YCor() {
		
	}
	
	public double execute() {
		return myTurtleHandler.getTurtleLocation().getY();
	}

}
