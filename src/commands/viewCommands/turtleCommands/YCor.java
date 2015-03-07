package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public class YCor extends TurtleCommands{
	
	public YCor(ViewHandler v) {
		super(v);
	}
	
	public double execute() {
		return super.getHandler().getTurtleLocation().getY();
	}

}
