package commands;

public class Sin extends Calculate{

	private int angle;
	
	public Sin(int a) {
		angle = a;
	}
	
	public void setParams(int a) {
		angle = a;
	}
	
	public void execute() {
		super.sin(angle);
	}

}
