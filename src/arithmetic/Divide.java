package arithmetic;

public class Divide extends Arithmetic{

	protected int div(int a, int b){
		return super.mult(a, 1/b);
	}

}
