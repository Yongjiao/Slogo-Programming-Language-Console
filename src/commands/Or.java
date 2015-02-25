package commands;

public class Or extends Compare{
	
	private int test1;
	private int test2;
	
	public Or(int t1, int t2) {
		test1 = t1; test2 = t2;
	}
	
	public void execute() {
		super.OR(test1, test2);
	}

}
