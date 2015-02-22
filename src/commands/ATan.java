package commands;

public class ATan extends Calculate{

	public ATan(int a) {
		super(a);
	}
	
	public double execute(int a) {
		return Math.atan(a);
	}
}
