package commands.viewCommands;

import application.Pen;
import application.PenHandler;

public class IsPD extends ViewCommands{
	
	public IsPD(PenHandler p) {
		super(p);
	}
	
	public double execute() {
		if(super.getPenHandler().getPenStatus() == 1)
			return 1;
		return 0;
	}

}
