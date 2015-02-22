package commands;

public class Tan extends Calculate{

	public Tan(int a) {
		super(a);
	}
	
	public double execute(int a){
		return Math.tan(a);
	}

}
