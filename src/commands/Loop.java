package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class Loop extends CommandFactory {

	public void Loop(int a, int b, ArrayList<CommandObject> commands) {
		for (int i = 0; i < a; i++) {
			commands.get(i);
		}
	}

}
