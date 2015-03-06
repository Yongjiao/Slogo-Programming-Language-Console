package commands;

public class IsPD extends Queries{
	
	public IsPD() {
		
	}
	
	public double execute() {
		if(myViewHandler.getPenStatus() == 1)
			return 1;
		return 0;
	}

}
