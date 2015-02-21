package arithmetic;

public class Remainder extends Arithmetic{
	
	protected int remainder(int a, int b){
		int c = super.div(a, b);
		return a - (b * c);
	}

}
