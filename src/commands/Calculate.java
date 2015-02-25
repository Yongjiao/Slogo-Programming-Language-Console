package commands;

import application.CommandFactory;

public abstract class Calculate extends CommandFactory {

	public double atan(Object[] o) {
		return Math.atan((Integer)o[0]);
	}

	public double cos(Object[] o) {
		return Math.cos((Integer)o[0]);
	}

	public double log(Object[] o) {
		return Math.log((Integer)o[0]);
	}

	public double Minus(Object[] o) {
		return -(Integer)o[0];
	}

	public double pi() {
		return Math.PI;
	}
	
	public double pow(Object[] o) {
		return Math.pow((Integer)o[0], (Integer)o[1]);
	}
	
	public double Random(Object[] o) {
		double r = Math.random() * (Integer)o[0];
		return r;
	}
	
	public double sin(Object[] o) {
		return Math.sin((Integer)o[0]);
	}
	
	public double tan(Object[] o) {
		return Math.tan((Integer)o[0]);
	}
}
