package commands;

import application.CommandFactory;
import application.ViewHandler;

public class Pen extends CommandFactory{
	
	ViewHandler myViewHandler;
	
	public Pen() {
		myViewHandler = super.getViewHandler();
	}
	
}
