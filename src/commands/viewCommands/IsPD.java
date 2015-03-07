package commands.viewCommands;

public class IsPD extends ViewCommands{
	
	public IsPD() {
		
	}
	
	public double execute() {
		if(super.getPen().getStatus() == 1)
			return 1;
		return 0;
	}

}
