package commands;

public class Remainder extends Arithmetic{

	private int dividend;
	private int divisor;
	
	public Remainder(int a, int b){
		dividend = a;
		divisor = b;
	}
	
	public void setParams(int a, int b) {
		dividend = a;
		divisor = b;
	}
	
	public void execute() {
		super.remainder(dividend, divisor);
	}
	
}
