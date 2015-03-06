package commands.arithmeticCommands;

import java.util.ArrayList;

public class Log extends Calculate{
	
	public Log(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execut() {
		double num = (Integer) params.get(params.size() - 1);
		return Math.log(num);
	}

}
