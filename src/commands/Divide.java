package commands;

public class Divide extends Arithmetic{

	public int div(int a, int b){
		return super.mult(a, 1/b);
	}

}
