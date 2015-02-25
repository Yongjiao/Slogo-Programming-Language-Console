package commands;

public class SetHeading extends Rotate{
	
	private int angle;
	
	public SetHeading(int a){
		angle = a;
	}
	
	public void setParams(int a) {
		angle = a;
	}
	
	public void execute() {
		super.setHeading(angle);
	}
	
}
