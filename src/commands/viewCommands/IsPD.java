package commands.viewCommands;

import application.Pen;

public class IsPD extends ViewCommands{
	
	public IsPD(Pen p) {
		super(p);
	}
	
	public double execute() {
		if(super.getPen().getStatus() == 1)
			return 1;
		return 0;
	}

}
