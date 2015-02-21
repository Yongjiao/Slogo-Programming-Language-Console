package commands;

public class Pow extends Calculate{

	public Pow(int a) {
		super(a);
	}
	
	public double execute(int a, int b){
		return Math.pow(a, b);
	}

}
