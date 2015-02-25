package commands;

import java.util.ArrayList;

import javax.activation.CommandObject;

public class DoTimes extends Loop{
	
	public DoTimes() {
	}
	
	public void execute(int m, ArrayList<CommandObject> c) {
		super.Loop(0, m, c);
	}

}
