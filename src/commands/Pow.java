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
	
	public int execute() {
		return super.pow(base, exponent);
	}
	
}
