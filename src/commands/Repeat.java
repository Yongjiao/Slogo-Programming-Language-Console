package commands;

import java.util.ArrayList;

public class Repeat extends Loop{

	public Repeat(int a, int b, ArrayList<String> commands) {
		super();
	}

	public void execute(int m, ArrayList<String> c) {
		super.Loop(0, m, c);
	}
	
}
