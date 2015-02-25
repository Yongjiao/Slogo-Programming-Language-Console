package commands;

public class Divide extends Arithmetic{

	public Divide(){
		
	}
	
	public void execute(int a, int b) {
		super.mult(a, 1/b);
	}

}
