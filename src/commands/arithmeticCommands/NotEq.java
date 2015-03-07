package commands.arithmeticCommands;

import java.util.ArrayList;

public class NotEq extends Compare{

	public NotEq(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double a = (Double) params.get(params.size() - 2);
		double b = (Double) params.get(params.size() - 1);
		if(a != b)
			return 1;
		return 0;
	}

}
