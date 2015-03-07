package commands.viewCommands.turtleCommands;

public class XCor extends TurtleCommands{
	
	public XCor() {
		
	}
	
	public double execute() {
		return super.getHandler().getTurtleLocation().getX();
	}

}
