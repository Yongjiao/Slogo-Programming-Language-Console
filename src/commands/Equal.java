package commands;

public class Equal extends Compare{
	
	private int num1;
	private int num2;
	
	public Equal(int a, int b){
		num1 = a; num2 = b;
	}
	
	public void setParams(int a, int b){
		num1 = a; num2 = b;
	}
	
	public void execute() {
		super.Equal(num1, num2);
	}

}
