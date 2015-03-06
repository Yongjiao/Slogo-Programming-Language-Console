package configuration;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import Tree.Node;
/**
 * super class for input parsing and validation
 * @author Yongjiao Yu
 *
 */
public abstract class Configuration {
	protected String comment, constant, variable, command, liststart, listend, groupstart,groupend;		
	protected HashMap<String, String> lanMap;
	protected HashSet<String> userdefined;
	protected List<Entry<String, Pattern>> patterns; 

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
	
	protected Queue<String> toCommandQueue(String str) {
		String[] s = str.split(" ");
		Queue<String> qu = new LinkedList<String>();
		for(int i =0; i < s.length; i++){
			qu.add(s[i]);
		}
		return qu;
	}	
	protected void skip(Queue<String> qu){
		qu.poll();
	}
	protected boolean isEnd(Queue<String> qu){
		return qu.isEmpty();
	}
	protected boolean isListEnd(String s){
		return s.matches(listend);
	}
	protected double executeAll(ArrayList<Node> commands){
		double result = -1;
		for(int i =0; i < commands.size(); i++)
			result = commands.get(i).getValue();
		return result;
	}
}
