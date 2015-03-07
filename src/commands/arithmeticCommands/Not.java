package commands.arithmeticCommands;

import java.util.ArrayList;

public class Not extends Compare{
	
	public Not(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double t = (Double) params.get(params.size() - 1);
		if(t == 0)
			return 1;
		return 0;
	}

}
