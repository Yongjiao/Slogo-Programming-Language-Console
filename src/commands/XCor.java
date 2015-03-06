package commands;

public class XCor extends Queries{
	
	public XCor() {
		
	}
	
	public double execute() {
		return myViewHandler.getTurtleLocation().getX();
	}

}
