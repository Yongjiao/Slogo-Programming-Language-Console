package commands;

public class Not extends Compare{
	
	private int test;
	
	public Not(int t) {
		test = t;
	}
	
	public void execute() {
		super.NOT(test);
	}

}
