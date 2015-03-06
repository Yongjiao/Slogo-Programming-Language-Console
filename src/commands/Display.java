package commands;

import java.util.ArrayList;

import application.CommandFactory;
import application.TurtleHandler;

public class Display extends CommandFactory{
	
	protected TurtleHandler myTurtleHandler;
	protected ArrayList<Object> params;
	
	public Display() {
		myTurtleHandler = super.getTurtleHandler();
		super.setParams(params);
	}

}
