package commands;

public class NotEq extends Compare{
	
	public NotEq(){
	}
	
	public void execute(Object[] o) {
		super.notEqual(o);
	}

}
