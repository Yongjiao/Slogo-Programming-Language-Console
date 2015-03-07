package commands;

import java.util.HashMap;

public class UserMadeUtilities {
	
	private static HashMap<String, Double> globalVars = new HashMap<>(); ;
	private static HashMap<String, UserDefined> UDCommands = new HashMap<>();;
	
	public UserMadeUtilities() {
		globalVars.put("PI", Math.PI); 
	}
	
	public void emptyVars() {
		globalVars.clear();
	}
	
	public static void putInVars(String str, Double d) {
		globalVars.put(str, d);
	}
	
	public static Double getFromVars(String str) {
		return globalVars.get(str);
	}
	
	public static boolean containsVars(String str){
		return globalVars.containsKey(str);
	}
	
	public void emptyCommands() {
		UDCommands.clear();
	}
	
	public static void putInCommands(String str, UserDefined c) {
		UDCommands.put(str, c);
	}
	
	public static UserDefined getFromCommands(String str) {
		return UDCommands.get(str);
	}

}
