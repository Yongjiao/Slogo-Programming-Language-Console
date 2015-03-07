package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public class XCor extends TurtleCommands{
	
	public XCor(ViewHandler v) {
		super(v);
	}
	
	public double execute() {
		return super.getHandler().getTurtleLocation().getX();
	}

}
