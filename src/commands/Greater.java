package commands;

public class Greater extends Compare{
	
	private int num1;
	private int num2;
	
	public Greater(int a, int b){
		num1 = a; num2 = b;
	}
	
	public void setParams(int a, int b){
		num1 = a; num2 = b;
	}
	
	public void execute() {
		super.Less(num2, num1);
	}
	
}
