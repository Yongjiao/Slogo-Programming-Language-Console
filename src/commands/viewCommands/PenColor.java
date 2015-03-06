package commands.viewCommands;


public class PenColor extends ViewCommands{
	
	public PenColor() {
		
	}
	//Anika
	public double execute() {
		return super.getPen().getCurrentColorIndexFromPalette();
	}

}
