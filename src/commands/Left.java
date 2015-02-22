package commands;

public class Left extends Rotate{

	public int left(int degrees){
		super.changeOrientation(-degrees);
		return degrees;
	}
	
}
