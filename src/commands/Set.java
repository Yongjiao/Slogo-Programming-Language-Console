package commands;

public class Set extends SetVariable {

	public Set(String name, int value) {
		super(name, value);
	}

	public void execute(String name, int value) {
		variables.put(name, value);
	}

}
