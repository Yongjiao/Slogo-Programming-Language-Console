package commands;

public class NotEq extends Compare{

	private int num1;
	private int num2;
	
	public NotEq(int a, int b){
		num1 = a; num2 = b;
	}
	
	public void setParams(int a, int b){
		num1 = a; num2 = b;
	}
	
	public void execute() {
		super.notEqual(num1, num2);
	}

}
