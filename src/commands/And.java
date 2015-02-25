package commands;

public class And extends Compare{
	
	private int test1;
	private int test2;
	
	public And(int t1, int t2) {
		test1 = t1; test2 = t2;
	}
	
	public void execute() {
		super.AND(test1, test2);
	}

}
