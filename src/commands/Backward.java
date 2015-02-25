package commands;

public class Backward extends Move{

	public Backward(){
		
	}
	
	public void execute(int steps) {
		super.changeLocation(steps);
	}
	
}
