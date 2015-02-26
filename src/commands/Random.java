package commands;

public class Random extends Calculate{

	private int max;
	
	public Random(int a) {
		max = a;
	}
	
	public void setParams(int a) {
		max = a;
	}
	
	public int execute() {
		return super.Random(max);
	}
	
}
