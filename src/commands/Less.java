package commands;

public class Less extends Compare{

	private int num1;
	private int num2;
	
	public Less(int a, int b){
		num1 = a; num2 = 2;
	}
	
	public void setParams(int a, int b){
		num1 = a; num2 = 2;
	}
	/*
	 * Modified: need execute() to return result of boolean expression
	 * 
	 */
	public int execute() {
		return super.Less(num1, num2);
	}
	
}
