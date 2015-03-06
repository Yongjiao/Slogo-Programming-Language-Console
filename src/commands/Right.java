package commands;

import java.util.ArrayList;

public class Right extends Rotate{
	
	public Right(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}

	public double execute() {
		double angle = (Integer) params.get(params.size() - 1);
		return super.changeOrientation(angle);
	}
	
}
