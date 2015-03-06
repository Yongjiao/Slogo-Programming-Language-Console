package commands;

import java.util.ArrayList;

public class Or extends Compare{
	
	public Or(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double t1 = (Integer) params.get(params.size() - 2);
		double t2 = (Integer) params.get(params.size() - 1);
		if((t1 != 0) || (t2 != 0))
			return 1;
		return 0;
	}

}
