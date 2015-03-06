package commands.viewCommands.turtleCommands;

import java.util.ArrayList;

import application.CommandFactory;
import application.ViewHandler;

public class Display extends CommandFactory{
	
	protected ViewHandler myTurtleHandler;
	protected ArrayList<Object> params;
	
	public Display() {
		myTurtleHandler = super.getViewHandler();
		super.setParams(params);
	}

}
