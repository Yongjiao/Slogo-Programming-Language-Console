package commands.viewCommands;

public class PenUp extends ViewCommands{
	
	public PenUp() {
		
	}
	
	public double execute() {
		super.getPen().setStatus(0);
		return 0;
	}
	
}
