package commands;

import application.CommandFactory;
import application.ViewHandler;

public class Queries extends CommandFactory{
	
	protected ViewHandler myViewHandler;
	
	public Queries() {
		myViewHandler = super.getViewHandler();
	}

}
