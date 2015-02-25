package commands;

public class Tan extends Calculate{

	private int angle;
	
	public Tan(int a) {
		angle = a;
	}
	
	public void setParams(int a) {
		angle = a;
	}
	
	public void execute() {
		super.tan(angle);
	}
}
