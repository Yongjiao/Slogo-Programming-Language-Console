package commands;

import java.util.ArrayList;

public class Greater extends Compare{

	public Greater(ArrayList<Object> p) {
		params = p;
	}
	
	public double execute() {
		double a = (Integer) params.get(params.size() - 2);
		double b = (Integer) params.get(params.size() - 1);
		if(a > b)
			return 1;
		return 0;
	}
	
}
