package commands;

public class Subtract extends Arithmetic{

	private int num1;
	private int num2;
	
	public Subtract(int a, int b){
		num1 = a; num2 = b;
	}
	
	public void setParams(int a, int b) {
		num1 = a; num2 = b;
	}
	
	public int execute() {
		return super.add(num1, -num2);
	}
	
}
