package configuration;

import java.io.FileInputStream;
import java.util.*;
import java.util.regex.*;
/*
 * To Do: language change
 * make one more map
 * cant combine the error check with parsing cuz the two requires different regex 	
 * expression check
 * expr checked by using validateBasicCommands: like 1 > 5
 */
public class ErrorCheck {
	private HashMap<String, String> commandMap;
	private HashSet<String> userdefined;
	private final String onenum = "\\s\\d+"; //one parameter only exactly one space between parameters
	private final String twonum = "\\s\\d+\\s\\d+";	//two parameter
	private final String com_regix = "\\s\\[(.*?)\\]"; //[command]
	private final String variable = "\\s:\\w+";
	private final String constant = "-?\\d+.?\\d*";
	private final String commandname = "\\w+[?]?";	
	private final String boolean_regix = "\\s(less\\?\\s\\d+\\s\\d+| greater\\?\\s\\d+\\s\\d+ | euqal\\?\\s\\d+\\s\\d+)";
	private HashMap<String, String> lanMap;
	
	private final String[] command = new String[]{"fd", "forward", "backward", "bk", "settowards", "tw", "setxy", "sum", "+", "difference","-", "product","*",
			"quotient","remainder", "%", "/","#","left", "lt", "right", "rt", "setheading", "seth", "sine", "cosine", "tangent", "arctangent", "repeat", "dotimes","for",
			"if","ifelse", "makeuserinstruction", "make", "set","less?", "greater?", "equal?"};
	
	private final String[] regix = new String[]{ "^fd"+ onenum,"^forward" + onenum, "^backward" +onenum, "^bk"+ onenum, "^settowards"+twonum, "^tw" + twonum, "^setxy" + twonum,
			"^sum" + twonum, "^+" + twonum, "^difference"+ twonum, "^-" + twonum, "^product" + twonum, "^*" + twonum, "^quotient" + twonum,
			"^remainder" + twonum, "^%" + twonum, "^/" + twonum, "^#.*", "^left" +onenum,"^lt" +onenum, "^right" +onenum,"^rt" +onenum, "setheading" +onenum,
			"^seth" +onenum,"^sin" +onenum,"^cos" +onenum, "^tan" +onenum, "^atan" +onenum, "repeat"+onenum +com_regix, 
			"dotimes"+ "\\s\\["+variable+ onenum +"\\s\\]"+com_regix, "for \\[" + variable + twonum + onenum + "\\s\\]" + com_regix,
			"if" + boolean_regix + com_regix, "ifelse" + boolean_regix  + com_regix + com_regix, "makeuserinstruction "+commandname + "\\s\\[" + variable + "\\s\\]" + com_regix,
			"make" + variable + "\\s.*", "set" + variable + "\\s.*", "less\\?"+ twonum, "greater\\?" + twonum, "equal\\?" + twonum};	
	public boolean validateInput(String in){ 
		String s = in.trim().toLowerCase();//sanitized input 
		String command = s.split(" ")[0];
		System.out.println(in);
		String comKey = lanMap.get(command);
		if(comKey == null)	return false;
		String commandRegix = commandMap.get(comKey);
		System.out.println(comKey);
		if(commandRegix != null){  //undefined commands
			s = s.replaceFirst(command, comKey);
			//System.out.println(s);
			if(userdefined.contains(command)){
				return validateLoop(commandRegix, s);					
			}
			else{
				return validateBasicCommands(commandRegix, s);
			}
		}
		return false;
	}		
	public boolean validateBasicCommands(String regex, String in){
			//call parser here.	
		System.out.println(regex + "" +in);
			return in.matches(regex);
	}
	public boolean validateLoop(String regix, String in){ //loop have multiple commands
		Pattern p = Pattern.compile(regix);
		Matcher m = p.matcher(in);		
		while(m.find()){
			for(int i = 1; i <= m.groupCount(); i++){
				if(!validateInput(m.group(i)))	return false;
			}
			return true;
		}
		return false;
	}
	public void setLanguage(ResourceBundle r){
		lanMap  = new HashMap<>();
		HashSet<String> m = (HashSet<String>) r.keySet();	
		for( String key: m){
			String value = r.getString(key);
			String[] val = value.split("\\|");
			for(int i=0; i< val.length; i++){
				lanMap.put(val[i].toLowerCase(), key.toLowerCase());
			}
		}
	}

	public ErrorCheck(){
	    ResourceBundle myBundle = ResourceBundle.getBundle("resources.languages.English");
	    setLanguage(myBundle);//English property file
	    String elements[] = { "ifelse", "if", "dotimes", "repeat", "for" };
		userdefined = new HashSet(Arrays.asList(elements));
		commandMap = new HashMap(); //what if new commands added
		for(int i=0; i < command.length; i++){
			commandMap.put(command[i],regix[i]);			
		}
	}

	public static void main(String[] args) {
		//ErrorCheck example = new ErrorCheck();
		String s1 = "fd 1";
		String s2= "sum 50 50";
		String s4 = "# ignore this is just comment!"; //broken when no space after #
		String s3 = "sum a b";
		String s5 = "REmainder 50 50";
		String s6 = " rt 50   ";
		String s7= "setheading 30";
		String repeat = "repeat 10 [ fd 50 ]";
		String dotimes = "dotimes [ :name 200 ] [ rt 50 ]";
		String forl = "for [ :v 0 10 1 ] [ lt 50 ]"; 
		String ifl = "if less? 1 5 [backward 30]";
		String ifelse = "ifelse greater? 2 6 [rt 50] [lt 100]";
		String set = "set :m [SUM 5 100]";
		String make = "make :n [% 30 40]";//change to set
		String to = "to line [ :va ] [ back 40 ]";
		ErrorCheck example = new ErrorCheck( );
		System.out.println(example.validateInput(ifl));		
		//System.out.println(example.validateInput(s2));
		//System.out.println(example.validateInput(s3));
		//System.out.println(example.validateInputCommands(s4));
		//System.out.println(example.validateInput(s5));
		//System.out.println(example.validateInputCommands(s6));
		//System.out.println(example.validateInputCommands(s7));
		//System.out.println(example.validateInput(repeat));		
		//System.out.println(example.validateInput(dotimes));
		//System.out.println(example.validateInput(forl));
		//System.out.println(example.validateInput(make));
		//System.out.println(example.validateInput(to));
		//System.out.println(example.validateInput(ifelse)); //make sure of ifelse again
		//System.out.println(example.validateInput(ifl));

	}	
}
