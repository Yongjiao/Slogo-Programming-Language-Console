package commands;

import java.util.ArrayList;

public class Multiply extends Arithmetic{

	public Multiply(ArrayList<Object> p){
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double num1 = (Integer) params.get(params.size() - 2);
		double num2 = (Integer) params.get(params.size() - 1);
		return num1 * num2;
	}

}
