package commands;

public class Remainder extends Arithmetic{
	
	public int remainder(int a, int b){
		int c = super.div(a, b);
		return a - (b * c);
	}

}
