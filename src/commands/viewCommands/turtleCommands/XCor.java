package commands.viewCommands.turtleCommands;

public class XCor extends Queries{
	
	public XCor() {
		
	}
	
	public double execute() {
		return myViewHandler.getTurtleLocation().getX();
	}

}
