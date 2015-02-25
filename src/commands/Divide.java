package commands;

public class Divide extends Arithmetic{

	private int dividend;
	private int divisor;
	
	public Divide(int a, int b){
		dividend = a; divisor = b;
	}
	
	public void setParams(int a, int b) {
		dividend = a; divisor = b;
	}
	
	public void execute() {
		super.mult(dividend, 1/divisor);
	}

}
