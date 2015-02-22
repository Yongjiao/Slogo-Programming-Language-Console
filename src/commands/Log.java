package commands;

public class Log extends Calculate{

	public Log(int a) {
		super(a);
	}
	
	public double execute(int a){
		return Math.log(a);
	}

}
