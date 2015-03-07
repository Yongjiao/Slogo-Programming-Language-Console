package commands.viewCommands.turtleCommands;

public class YCor extends TurtleCommands{
	
	public YCor() {
		
	}
	
	public double execute() {
		return super.getHandler().getTurtleLocation().getY();
	}

}
