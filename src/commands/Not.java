package commands;

import java.util.ArrayList;

public class Not extends Compare{
	
	public Not(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double t = (Integer) params.get(params.size() - 1);
		if(t == 0)
			return 1;
		return 0;
	}

}
