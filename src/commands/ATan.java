package commands;

import java.util.ArrayList;

public class ATan extends Calculate {

	private int angle;
	
	public ATan(int a) {
		ArrayList<Integer> l = super.getParams();
		angle = l.get(l.size() - 1);
	}
	
	public int execute() {
		return (int) Math.round(Math.atan(angle));
	}
}
