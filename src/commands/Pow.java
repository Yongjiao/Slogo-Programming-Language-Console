package commands;

public class Pow extends Calculate{

	private int base;
	private int exponent;
	
	public Pow(int a, int b) {
		base = a; exponent = b;
	}
	
	public void setParams(int a, int b) {
		base = a; exponent = b;
	}
	
	public void execute() {
		super.pow(base, exponent);
	}
	
}
