package commands;

public class Tan extends Calculate{

	private int angle;
	
	public Tan(int a) {
		angle = a;
	}
	
	public void setParams(int a) {
		angle = a;
	}
	
	public int execute() {
		return super.tan(angle);
	}
}
