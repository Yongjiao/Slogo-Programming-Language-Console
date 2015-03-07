package commands.viewCommands;

public class PenDown extends ViewCommands{
	
	public PenDown() {
		
	}
	
	public double execute() {
		super.getPen().setStatus(1);
		return 1;
	}

}
