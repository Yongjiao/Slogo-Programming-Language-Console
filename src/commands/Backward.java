package commands;

public class Backward extends Move{
	
	private int steps;

	public Backward(int s){
		steps = s;
	}
	
	public void setParams(int s) {
		steps = s;
	}
	
	public int execute() {
		return super.changeLocation(-steps);
	}
}
