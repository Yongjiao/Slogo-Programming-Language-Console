package commands.viewCommands.turtleCommands;

import java.util.ArrayList;
import java.util.HashMap;

import commands.UserDefined;
import commands.UserMadeUtilities;

import application.CommandFactory;

public class RunUD extends TurtleCommands {

	private String name;
	private ArrayList<Object> values;

	public RunUD(String n, ArrayList<Object> vals) {
		name = n;
		values = vals;
	}

	public double execute() {
		UserDefined thisOne = UserMadeUtilities.getFromCommands(name)
				.makeInstanceOfSelf();
		if (thisOne.getParams().size() != values.size()) {
			return 0;
		}

		/**
		 * @author Anika, Richard
		 * 
		 * 
		 *         - create map of params : vals - for each command --> replace
		 *         if needed
		 * 
		 */

		HashMap<String, Object> myParamValMap = new HashMap<String, Object>();

		for (int i = 0; i < thisOne.getParams().size(); i++) {
			myParamValMap.put(thisOne.getParams().get(i), values.get(i));
		}

		int j = 0;

		for (CommandFactory comm : thisOne.getCommands()) {
			// comm.getParams().add(values.get(j));
			// comm.execute();

			ArrayList<Object> thisCommParams = comm.getParams();

			for (int m = 0; m < thisCommParams.size(); m++) {
				Object thisParam = thisCommParams.get(m);
				while (!(thisParam instanceof Double)) // if this parameter is
														// NOT a double
				{
					// replace
					// check if local var

					if (myParamValMap.containsKey(thisParam)) {
						ArrayList<Object> ps = comm.getParams();
						ps.set(m, myParamValMap.get(thisParam));
						comm.setParams(ps);
					}

				}
			}
			comm.execute();

			j++;
		}
		return 1;
	}

}
