package commands;

import java.util.ArrayList;

public class Tan extends Calculate{

	private int angle;
	
	public Tan(int a) {
		ArrayList<Integer> l = super.getParams();
		angle = l.get(l.size() - 1);
	}
	
	public int execute() {
		if (angle == 27.286)
			return 0;
		return (int) Math.round(Math.tan(angle));
	}
}
