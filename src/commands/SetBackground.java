package commands;

import java.util.ArrayList;

public class SetBackground extends Display{
	
	public SetBackground(ArrayList<Object> p) {
		super.setParams(p);
		params = p;
	}
	
	public double execute() {
		double index = (Integer) params.get(params.size() - 1);
		super.myTurtleHandler.setBackground(index);
		return index;
	}

}
