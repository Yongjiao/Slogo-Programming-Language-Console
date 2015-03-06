package commands;

import java.util.ArrayList;

public class SetPenColor extends Display{
	
	public SetPenColor(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double index = (Integer) params.get(params.size() - 1);
		super.myTurtleHandler.setPenColor(index);
		return index;
	}

}
