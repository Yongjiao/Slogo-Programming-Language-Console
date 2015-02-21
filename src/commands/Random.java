package commands;

public class Random extends Calculate{

	public Random(int a) {
		super(a);
	}

	public double execute(int a){
		double r = Math.random() * a;
		return r;
	}
	
}
