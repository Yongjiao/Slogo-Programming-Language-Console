package commands.viewCommands.turtleCommands;

public class Home extends Move{
	
	public Home() {
		
	}
	
	public double execute(){
		return super.goToLocation(0, 0);
	}

}
