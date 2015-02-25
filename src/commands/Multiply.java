package commands;

public class Multiply extends Arithmetic{

	private int multiplier;
	private int multiplicand;
	
	public Multiply(int a, int b){
		multiplier = a;
		multiplicand = b;
	}
	
	public void setParams(int a, int b) {
		multiplier = a;
		multiplicand = b;
	}
	
	public void execute() {
		super.mult(multiplier, multiplicand);
	}

}
