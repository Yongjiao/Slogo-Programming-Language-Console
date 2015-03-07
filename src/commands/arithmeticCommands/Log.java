package commands.arithmeticCommands;

import java.util.ArrayList;

public class Log extends Calculate{
	
	public Log(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double num = (Double) params.get(params.size() - 1);
		return Math.log(num);
	}

}
