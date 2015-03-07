package commands;

import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserMadeUtilities {
	

	private static HashMap<String, Double> globalVars = new HashMap<>();
	private static HashMap<String, UserDefined> UDCommands = new HashMap<>();
	
	private ObservableList<String> myVarsList = FXCollections.observableArrayList();
	private ObservableList<String> myUserDefinedCommandsList = FXCollections.observableArrayList();

	
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
	
	public ObservableList<String> getAllVars(){
		return myVarsList;
	}
	
	public ObservableList<String> getUDCommands(){
		return myUserDefinedCommandsList;
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
	
	public void checkUDCommands() {
		for (String s : UDCommands.keySet()){
			String result = s + " = " + UDCommands.get(s).getCommands();
			if (!myUserDefinedCommandsList.contains(result))
				myUserDefinedCommandsList.add(result);
		}
	}

	public void checkVars() {
		for (String s : globalVars.keySet()){
			String result = s + " = " + globalVars.get(s);
			if (!myVarsList.contains(result))
				myVarsList.add(result);
		}
	}

}
