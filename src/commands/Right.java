package commands;

public class Right extends Rotate{
	
	public int right(int degrees){
		super.changeOrientation(degrees);
		return degrees;
	}
	
}
