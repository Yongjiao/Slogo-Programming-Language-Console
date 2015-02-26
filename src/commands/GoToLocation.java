package commands;

public class GoToLocation extends Move{

	private int x;
	private int y;
	
	public GoToLocation(int xCor, int yCor) {
		x = xCor; y = yCor;
	}
	
	public void setParams(int xCor, int yCor) {
		x = xCor; y = yCor;
	}
	
	public int execute(){
		return super.GoToLocation(x, y);	
	}

}
