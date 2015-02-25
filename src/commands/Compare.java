package commands;

import application.CommandFactory;

public abstract class Compare extends CommandFactory{
	
	public int Less(Object[] o){
		if((int)o[0] < (int)o[1])
			return 1;
		return 0;
	}
	
	public int Equal(Object[] o){
		if(o[0] == o[1])
			return 1;
		return 0;
	}
	
	public int notEqual(Object[] o) {
		if(o[0] == o[1])
			return 0;
		return 1;
	}
	
}
