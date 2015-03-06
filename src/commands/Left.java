package commands;

import java.util.ArrayList;

public class Left extends Rotate{
	
	public Left(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}

	public double execute() {
		double angle = (Integer) params.get(params.size() - 1);
		return super.changeOrientation(-angle);
	}
	
}
