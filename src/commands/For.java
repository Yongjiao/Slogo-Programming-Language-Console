package commands;

import java.util.ArrayList;

import javax.activation.CommandObject;

public class For extends Loop{
	
	public For() {
		
	}
	
	public void execute(int p, int q, ArrayList<CommandObject> c){
		super.Loop(p, q, c);
	}

}
