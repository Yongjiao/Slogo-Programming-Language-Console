package commands.arithmeticCommands;

import java.util.ArrayList;


/**
 * Command Subclass for addition
 * 
 * @author Richard
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
		System.out.println(num1 + num2 + "");
		return num1 + num2;
	}
	
}
