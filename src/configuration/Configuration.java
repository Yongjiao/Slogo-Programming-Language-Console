package configuration;

import java.util.*;
/**
 * super class for input validation and parsing
 * @author Yongjiao Yu
 *
 */
public abstract class Configuration {
	//private HashMap<String, String>	syntaxMap;
	protected String comment, constant, variable, command, liststart, listend, groupstart,groupend;		
	protected HashMap<String, String> lanMap;
	protected HashSet<String> userdefined;

	protected String onenum; //one parameter only exactly one space between parameters
	protected String twonum;	//two parameter
	protected String com_regix;//[command]
	protected String boolean_regix;
	protected final String[] commands = new String[]{"forward", "backward", "settowards", "setxy", "sum", "difference","product",
			"quotient","remainder", "#","left",  "right", "setheading", "sine", "cosine", "tangent", "arctangent", "repeat", "dotimes","for",
			"if","ifelse", "makeuserinstruction", "make", "set","lessthan", "greaterthan", "equal", "notequal", "makevariable", "notequal"};	
	
	protected void initialize(){
	    //initialize languageMap
		ResourceBundle myBundle = ResourceBundle.getBundle("resources.languages.English");
	    setLanguage(myBundle); //default English 	 
	    //initialize userdefined Set
		String elements[] = { "ifelse", "if", "dotimes", "repeat", "for","makevariable" };
		userdefined = new HashSet(Arrays.asList(elements));
	    //initialize syntaxMap
		initializeSyntax();
	}
	protected void setLanguage(ResourceBundle r){
		lanMap  = new HashMap<>();
		HashSet<String> m = (HashSet<String>) r.keySet();	
		for( String key: m){
			String value = r.getString(key);
			String[] val = value.split("\\|");
	  		//System.out.println(val[0]);
			for(int i=0; i< val.length; i++){
				lanMap.put(val[i].toLowerCase(), key.toLowerCase());
			}
		}
	}
	protected void initializeSyntax(){
		ResourceBundle b = ResourceBundle.getBundle("resources.languages.Syntax"); 
/*		syntaxMap = new HashMap<String, String>();	
 * 		HashSet<String> keys = (HashSet<String>) b.keySet();
		for(String key: keys){
			syntaxMap.put(key, b.getString(key));
		} */
		comment = b.getString("Comment");
		constant = b.getString("Constant");
		variable = b.getString("Variable");
		command = b.getString("Command");
		liststart = b.getString("ListStart");
		listend = b.getString("ListEnd");
		groupstart = b.getString("GroupStart");
		groupend = b.getString("GroupEnd");
		
	}	
	protected HashMap<String, String> initializeCommandMap(String[] commands, String[] regex){
		HashMap<String, String > commandMap = new HashMap(); 
		for(int i=0; i < commands.length; i++){
			commandMap.put(commands[i],regex[i]);			
		}
		return commandMap;
	}
	abstract protected void setSyntaxRegex();
}
