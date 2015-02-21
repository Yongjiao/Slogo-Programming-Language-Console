package application;

public abstract class Move extends CommandFactory{

	public int forward(int dist){
		
		myTurtleHandler.moveTurtle(dist);	
		return dist;
	}
}
