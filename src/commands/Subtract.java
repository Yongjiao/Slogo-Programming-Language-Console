package commands;

public class Subtract extends Arithmetic{

	public Subtract(){
	}
	
	public void execute(Object[] o){
		o[0] = -(Integer)o[0];
		super.add(o);
	}
	
}
