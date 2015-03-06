package commands;

import java.util.ArrayList;

public class Remainder extends Arithmetic{

	public Remainder(ArrayList<Object> p){
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double num1 = (Integer) params.get(params.size() - 2);
		double num2 = (Integer) params.get(params.size() - 1);
		double div = num1/num2;
		return num1 - (num2 * div);
	}
	
}
