package commands;

public class Log extends Calculate{

	private int num;
	
	public Log(int a) {
		num = a;
	}
	
	public void setParams(int a) {
		num = a;
	}
	
	public void execut() {
		super.log(num);
	}

}
