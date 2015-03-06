package commands;

import java.util.ArrayList;

public class SetPenSize extends Display{
	
	public SetPenSize(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double pixels = (Integer) params.get(params.size() - 1);
		super.myTurtleHandler.setPenSize(index);
		return pixels;
	}

}
