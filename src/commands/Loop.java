package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class Loop extends CommandFactory {

	public void loop(int a, int b, ArrayList<CommandFactory> commands) {
		for (int i = a; i < b; i++) {
			commands.get(i).execute();
		}
	}

}
