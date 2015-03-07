package commands.viewCommands.turtleCommands;

public class HideTurtle extends TurtleCommands{
	
	public HideTurtle() {
		
	}
	
	public double execute() {
		super.getHandler().showTurtle(0);
		return super.getHandler().isVisible();
	}

}
