package commands.arithmeticCommands;

import java.util.ArrayList;

public class Subtract extends Arithmetic{

	public Subtract(ArrayList<Object> p){
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double num1 = (Double) params.get(params.size() - 2);
		double num2 = (Double) params.get(params.size() - 1);
		return num1 - num2;
	}
	
}
