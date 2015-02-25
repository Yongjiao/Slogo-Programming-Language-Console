package commands;

import application.CommandFactory;

public abstract class Calculate extends CommandFactory {

	public double atan(int a) {
		return Math.atan(a);
	}

	public double cos(int a) {
		return Math.cos(a);
	}

	public double log(int a) {
		return Math.log(a);
	}

	public double Minus(int a) {
		return -a;
	}

	public double pi() {
		return Math.PI;
	}
	
	public double pow(int base, int exponent) {
		return Math.pow(base, exponent);
}
	
	public double Random(int a) {
		double r = Math.random() * a;
		return r;
	}
	
	public double sin(int a) {
		return Math.sin(a);
	}
	
	public double tan(int a) {
		return Math.tan(a);
	}
}
