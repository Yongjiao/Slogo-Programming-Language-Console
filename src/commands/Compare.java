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
	
}
