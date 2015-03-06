package commands;

import java.util.ArrayList;

public class Divide extends Arithmetic{

	public Divide(ArrayList<Object> p){
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double num1 = (Double) params.get(params.size() - 2);
		double num2 = (Double) params.get(params.size() - 1);
		return num1 / num2;
	}

}
