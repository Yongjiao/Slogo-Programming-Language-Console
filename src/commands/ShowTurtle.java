package commands;

public class ShowTurtle extends TurtScreen{
	
	public ShowTurtle() {
		
	}
	
	public double execute() {
		myViewHandler.showTurtle(1);
		return myViewHandler.isVisible();
	}

}
