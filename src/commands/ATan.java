package commands;

public class ATan extends Calculate {

	private int angle;
	
	public ATan(int a) {
		angle = a;
	}
	
	public void setParams(int a) {
		angle = a;
	}
	
	public void execute() {
		super.atan(angle);
	}
}
