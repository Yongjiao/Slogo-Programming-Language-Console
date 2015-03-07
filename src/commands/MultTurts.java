package commands;

import java.util.ArrayList;
import application.ViewHandler;

public class MultTurts extends CommandCenter{ //Superclass for multiple turtle themed commands
	
	protected ViewHandler myTurtleHandler;
	protected ArrayList<Object> turtles;
	protected ArrayList<CommandCenter> commands;
	
	public MultTurts(){
		
	}

	@Override
	public double execute() {
		// TODO Auto-generated method stub
		return 0;
	}

}
