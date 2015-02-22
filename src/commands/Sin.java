package commands;

public class Sin extends Calculate{

	public Sin(int a) {
		super(a);
	}
	
	public double execute(int a){
		return Math.sin(a);
	}

}
