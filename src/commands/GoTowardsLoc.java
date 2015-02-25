package commands;

import configuration.Parser;

public class GoTowardsLoc extends Rotate{
	
	private int x;
	private int y;
	
	public GoTowardsLoc(int xCor, int yCor) {
		x = xCor; y = yCor;
	}

	public void setParams(int xCor, int yCor) {
		x = xCor; y = yCor;
	}
	
	public void execute() {
		super.goTowardsLoc(x, y);
	}
	
	public static void main(String[] args) {
		GoTowardsLoc example = new GoTowardsLoc(20, 20);
		
		// TODO Auto-generated method stub

	}
}
