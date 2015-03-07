package commands.viewCommands.turtleCommands;

import java.util.ArrayList;
import java.util.HashMap;

import commands.CommandCenter;
import commands.UserDefined;
import commands.UserMadeUtilities;

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
		if (thisOne.getParameters().size() != values.size()) {
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

		for (int i = 0; i < thisOne.getParameters().size(); i++) {
			myParamValMap.put(thisOne.getParameters().get(i), values.get(i));
		}

		int j = 0;

		for (CommandCenter comm : thisOne.getCommands()) {
			// comm.getParams().add(values.get(j));
			// comm.execute();

			ArrayList<Object> thisCommParams = super.getParams();

			for (int m = 0; m < thisCommParams.size(); m++) {
				Object thisParam = thisCommParams.get(m);
				while (!(thisParam instanceof Double)) // if this parameter is
														// NOT a double
				{
					// replace
					// check if local var

					if (myParamValMap.containsKey(thisParam)) {
						ArrayList<Object> ps = super.getParams();
						ps.set(m, myParamValMap.get(thisParam));
						super.setParams(ps);
					}

				}
			}
			comm.execute();

			j++;
		}
		return 1;
	}
	
	public static void main (String[] arg) {
		String n = "circle";
		ArrayList<Object> vals = new ArrayList<Object>();
		RunUD runUD = new RunUD(n, vals);
	}

}
