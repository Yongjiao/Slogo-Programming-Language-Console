package commands.viewCommands.turtleCommands;

import application.ViewHandler;

public class Home extends Move{
	
	public Home(ViewHandler vh) {
		super(vh);
	}
	
	public double execute(){
		return super.goToLocation(0, 0);
	}

}
