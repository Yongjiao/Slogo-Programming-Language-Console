package configuration;

import java.util.*;

public abstract class Configuration {
	protected HashMap<String, String>	syntaxMap;
	protected HashSet<String> userdefined;
	protected HashMap<String, String> lanMap;
	protected String onenum; //one parameter only exactly one space between parameters
	protected String twonum;	//two parameter
	protected String com_regix;//[command]
	protected String variable;
	protected String constant;
	protected String commandname;	
	protected String boolean_regix;
	protected final String[] commands = new String[]{"forward", "backward", "settowards", "setxy", "sum", "difference","product",
			"quotient","remainder", "#","left",  "right", "setheading", "sine", "cosine", "tangent", "arctangent", "repeat", "dotimes","for",
			"if","ifelse", "makeuserinstruction", "make", "set","lessthan", "greaterthan", "equal", "notequal"};	
	
	protected void initialize(){
	    //initialize languageMap
		ResourceBundle myBundle = ResourceBundle.getBundle("resources.languages.English");
	    setLanguage(myBundle); //default English 	 
	    //initialize userdefined Set
		String elements[] = { "ifelse", "if", "dotimes", "repeat", "for" };
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
		syntaxMap = new HashMap<String, String>();
		ResourceBundle b = ResourceBundle.getBundle("resources.languages.Syntax");
		HashSet<String> keys = (HashSet<String>) b.keySet();
		for(String key: keys){
			syntaxMap.put(key, b.getString(key));
		}
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
