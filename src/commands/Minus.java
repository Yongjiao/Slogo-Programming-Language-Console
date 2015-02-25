package commands;

public class Minus extends Calculate{

	private int num;
	
	public Minus(int a) {
		num = a;
	}
	
	public void setParams(int a) {
		num = a;
	}
	
	public void execute() {
		super.Minus(num);
	}

}
