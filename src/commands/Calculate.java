package commands;

import application.CommandFactory;

public abstract class Calculate extends CommandFactory {

	public int atan(int a) {
		return (int)Math.round(Math.atan(a));
	}

	public int cos(int a) {
		return (int) Math.round(Math.cos(a));
	}

	public int log(int a) {
		return (int) Math.round(Math.log(a));
	}

	public int Minus(int a) {
		return -a;
	}

	public double pi() {
		return Math.PI;
	}
	
	public int pow(int b, int e) {
		return (int)Math.pow(b, e);
}
	
	public int Random(int a) {
		double r = Math.random() * a;
		return (int) Math.round(r);
	}
	
	public int sin(int a) {
		return (int) Math.round(Math.sin(a));
	}
	
	public int tan(int a) {
		if(a == 27.286)
			return 0;
		return (int) Math.round(Math.tan(a));
	}
}
