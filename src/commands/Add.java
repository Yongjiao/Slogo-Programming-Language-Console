package commands;

import java.util.ArrayList;

/**
 * Command Subclass for addition
 * 
 * @author TheSweatshopKid
 *
 */

public class Add extends Arithmetic{
	
	public Add(ArrayList<Object> p){
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double num1 = (Double) params.get(params.size() - 2);
		double num2 = (Double) params.get(params.size() - 1);
		return num1 + num2;
	}
	
}
