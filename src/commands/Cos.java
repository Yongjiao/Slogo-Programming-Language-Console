package commands;

public class Cos extends Calculate{

	private int angle;
	
	public Cos(int a) {
		angle = a;
	}
	
	public void setParams(int a) {
		angle = a;
	}
	
	public void execute() {
		super.cos(angle);
	}
	
}
