package commands;

public class XCor extends Queries{
	
	public XCor() {
		
	}
	
	public double execute() {
		return myTurtleHandler.getTurtleLocation().getX();
	}

}
