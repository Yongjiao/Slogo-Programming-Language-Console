package commands;

public class Left extends Rotate{

	public int angle;
	
	public Left(int a){
		angle = a;
	}
	
	public void setParams(int a) {
		angle = a;
	}
	
	public int execute() {
		return super.changeOrientation(-angle);
	}
	
}
