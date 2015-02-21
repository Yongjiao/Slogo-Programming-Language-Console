package commands;

public class Minus extends Calculate{

	public Minus(int a) {
		super(a);
	}
	
	public int execute(int a){
		return -a;
	}

}
