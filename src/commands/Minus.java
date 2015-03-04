package commands;

import java.util.ArrayList;

public class Minus extends Calculate{

	private int num;
	
	public Minus(int a) {
		ArrayList<Integer> l = super.getParams();
		num = l.get(l.size() - 1);
	}
	
	public int execute() {
		return -num;
	}

}
