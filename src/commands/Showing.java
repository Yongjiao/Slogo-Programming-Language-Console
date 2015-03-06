package commands;

public class Showing extends Queries{
	
	public Showing() {
		
	}
	
	public double execute() {
		if(myTurtleHandler.isVisible() == 1)
			return 1;
		return 0;
	}

}
