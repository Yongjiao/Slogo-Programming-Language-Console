package commands;

public class Cos extends Calculate{

	public Cos(int a) {
		super(a);
	}

	public double execute(int a){
		return Math.cos(a);
	}
	
}
