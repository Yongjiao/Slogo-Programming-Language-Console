package commands;

public class Make extends SetVariable{

	public Make(String name, int value) {
		super(name, value);
	}
	
	public void execute(String name, int value){
		variables.put(name, value);
	}

}
