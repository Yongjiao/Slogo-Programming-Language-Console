package commands;

public class Left extends Rotate{

	public int right(int degrees){
		super.changeOrientation(-degrees);
		return degrees;
	}
	
}
