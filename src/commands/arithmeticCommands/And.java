package commands.arithmeticCommands;

import java.util.ArrayList;

public class And extends Compare{
	
	public And(ArrayList<Object> p) {
		params = p;
	}
	
	public double execute() {
		double t1 = (Double) params.get(params.size() - 2);
		double t2 = (Double) params.get(params.size() - 1);
		if ((t1 != 0) && (t2 != 0))
			return 1;
		return 0;
	}

}
