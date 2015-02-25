package commands;

public class Add extends Arithmetic{
	
	private int num1;
	private int num2;
	
	public Add(int a, int b){
		num1 = a; num2 = b;
	}
	
	public void setParams(int a, int b) {
		num1 = a; num2 = b;
	}
	
	public void execute() {
		super.add(num1, num2);
	}
	
}
