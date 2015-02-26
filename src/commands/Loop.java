package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class Loop extends CommandFactory {

	public int loop(int a, int b, int c, ArrayList<CommandFactory> commands) {
		for (int i = 0; i < b; i += c) {
			commands.get(i).execute();
		}
		return commands.get(commands.size()).execute();
	}

}
