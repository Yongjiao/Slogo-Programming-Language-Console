package commands;

import application.CommandFactory;

public abstract class Compare extends CommandFactory{
	
	public int Less(int a, int b){
		if(a < b)
			return 1;
		return 0;
	}
	
	public int Equal(int a, int b){
		if(a == b)
			return 1;
		return 0;
	}
	
	public int notEqual(int a, int b) {
		if(a == b)
			return 0;
		return 1;
	}
	
	public int AND(int t1, int t2) {
		if ((t1 != 0) && (t2 != 0))
			return 1;
		return 0;
	}
	
	public int OR(int t1, int t2) {
		if((t1 != 0) || (t2 != 0))
			return 1;
		return 0;
	}
	
	public int NOT(int t) {
		if(t == 0)
			return 1;
		return 0;
	}
	
}
