package commands;

public class Right extends Rotate{
	
	public int angle;
	
	public Right(int a){
		angle = a;
	}
	
	public void setParams(int a) {
		angle = a;
	}
	
	public int execute() {
		return super.changeOrientation(angle);
	}
	
}
