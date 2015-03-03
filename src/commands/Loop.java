package commands;

import java.util.ArrayList;

import application.CommandFactory;

public class Loop extends CommandFactory {

	public int loop(int a, int b, int c, ArrayList<CommandFactory> commands) {
		for (int i = a; i < b; i += c) {
			for (int j = 0; j < commands.size(); j++)
				commands.get(j).execute();
		}
		return commands.get(commands.size() - 1).execute();
	}

}
