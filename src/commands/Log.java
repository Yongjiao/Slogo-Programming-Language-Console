package commands;

import java.util.ArrayList;

public class Log extends Calculate{

	private int num;
	
	public Log(int a) {
		ArrayList<Integer> l = super.getParams();
		num = l.get(l.size() - 1);
	}
	
	public int execut() {
		return (int) Math.round(Math.log(num));
	}

}
