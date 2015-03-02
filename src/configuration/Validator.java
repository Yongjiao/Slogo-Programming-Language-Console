package configuration;

import java.io.FileInputStream;
import java.util.*;
import java.util.regex.*;
/*
 * cant combine the error check with parsing cuz the two requires different regex 	
 *
 */
public class Validator extends Configuration{
	private HashMap<String, String> commandMap;
	//private String comKey = null; 
	private final String onenum = "\\s\\d+"; //one parameter only exactly one space between parameters
	private final String twonum = "\\s\\d+\\s\\d+";	//two parameter
	private final String com_regix = "\\s\\[(.*?)\\]"; //[command]
	private final String variable = "\\s:\\w+";
	private final String constant = "-?\\d+.?\\d*";
	private final String commandname = "\\w+[?]?";	
	private final String boolean_regix = "\\s(less\\?\\s\\d+\\s\\d+|greater\\?\\s\\d+\\s\\d+|equal\\?\\s\\d+\\s\\d+)";
	
/*	private final String[] command = new String[]{"fd", "forward", "backward", "bk", "settowards", "tw", "setxy", "sum", "+", "difference","-", "product","*",
			"quotient","remainder", "%", "/","#","left", "lt", "right", "rt", "setheading", "seth", "sine", "cosine", "tangent", "arctangent", "repeat", "dotimes","for",
			"if","ifelse", "makeuserinstruction", "make", "set","less?", "greater?", "equal?"};	
		private final String[] regex = new String[]{ "^forward" + onenum, "^backward" +onenum,"^settowards"+twonum, "^setxy" + twonum,
				"^sum" + twonum, "^difference"+ twonum, "^product" + twonum, "^quotient" + twonum,
				"^remainder" + twonum, "^#.*", "^left" +onenum, "^right" +onenum, "setheading" +onenum,
				"^seth" +onenum,"^sin" +onenum,"^cos" +onenum, "^tan" +onenum, "^atan" +onenum, "repeat"+onenum +com_regix, 
				"dotimes"+ "\\s\\["+variable+ onenum +"\\s\\]"+com_regix, "for \\[" + variable + twonum + onenum + "\\s\\]" + com_regix,
				"if" + boolean_regix + com_regix, "ifelse" + boolean_regix  + com_regix + com_regix, "makeuserinstruction "+commandname + "\\s\\[" + variable + "\\s\\]" + com_regix,
				"make" + variable + "\\s.*", "set" + variable + "\\s.*", "less\\?"+ twonum, "greater\\?" + twonum, "equal\\?" + twonum};
	*/
	private final String[] regex = new String[]{ onenum, onenum,  twonum, twonum, twonum, twonum,  twonum, twonum,
			 twonum,  ".*",onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum +com_regix, 
			 "\\s\\["+variable+onenum+"\\s\\]"+com_regix, "\\s\\[" + variable + twonum + onenum + "\\s\\]" + com_regix, boolean_regix + com_regix, 
			 boolean_regix  + com_regix + com_regix, "\\s" + commandname + "\\s\\[" + variable + "\\s\\]" + com_regix, variable + "\\s.*", variable + "\\s.*",
			 twonum,  twonum, twonum, twonum};
	
	public Validator(){
		initialize();
		commandMap = initializeCommandMap(commands, regex);
	}
	public boolean validateInput(String in){ 
		String s = in.trim().toLowerCase();//sanitized input 
		String command = s.split(" ")[0];
		System.out.println( "Input is " + in);		
		String comKey = lanMap.get(command); 
		String temp = command;
		if(comKey == null){ //traverse instead  command with //? or //* etc
			for(String k: lanMap.keySet()){
				if(command.matches(k)){
					comKey = lanMap.get(k);
					temp = k;
				}				
			}
		}
		System.out.println(comKey);	
		if(comKey != null){	
			if(s.equals("home")|s.equals("penup")| s.equals("pendown")|s.equals("clearscreen"))	return true; //those wont be in commandMap, or the regex as empty string in commandMap
			String commandRegex = commandMap.get(comKey);		
			//System.out.println("The command Regex is for " + comKey + " is " + commandRegex +".");
			//System.out.println("The head to be removed is " + temp);
			s = s.replaceFirst(temp, ""); //use keyRegex to remove it
			if(userdefined.contains(comKey)){
				return validateLoop(commandRegex, s);					
			}
			else{
				return validateBasicCommands(commandRegex, s);
			}
		}		
		
		return false;
	}		
	public boolean validateBasicCommands(String regex, String in){
			//call parser here.	
		System.out.println(regex + " matches?" +in);
			return in.matches(regex);
	}
	public boolean validateLoop(String regex, String in){ //loop have multiple commands
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(in);
		while(m.find()){
			for(int i = 1; i <= m.groupCount(); i++){
				if(!validateInput(m.group(i)))	return false;
			}
			return true;
		}
		return false;
	}
//	private String matchAnyRegex(String command) 
	
	public static void main(String[] args) {
		//ErrorCheck example = new ErrorCheck();
		String s1 = "fd 50";
		String s2= "sum 50 50";
		String s4 = "# ignore this is just comment!"; //broken when no space after #
		String s3 = "sum a b";
		String s5 = "REmainder 50 50";
		String s6 = " rt 50   ";
		String s7= "setheading 30";
		String repeat = "repeat 10 [ fd 50 ]";
		String dotimes = "dotimes [ :name 200 ] [ rt 50 ]";
		String forl = "for [ :v 0 10 1 ] [ lt 50 ]"; 
		String ifl = "if less? 1 5 [back 30]";
		String ifelse = "ifelse greater? 2 6 [ rt 50 ] [ lt 100 ]";
		String set = "set :m [ SUM 5 100 ]";
		String make = "make :n [ % 30 40 ]";//change to set
		String to = "to line [ :va ] [ back 40 ]";
		String circle = "repeat 180 [ fd 5 rt 2 ]";
		String less = "greater? 1 5";
		//String ss = "taibi";
		Validator example = new Validator();
		//System.out.println(example.validateInput(circle));		
		//System.out.println(example.validateInput(ss));
		//System.out.println(example.validateInput(s1));
		//System.out.println(example.validateInput(s2));
		//System.out.println(example.validateInput(s3));
		//System.out.println(example.validateInput(s4));
		//System.out.println(example.validateInput(s5));
		//System.out.println(example.validateInput(s6));
		//System.out.println(example.validateInput(s7));
		//System.out.println(example.validateInput(repeat));		
		//System.out.println(example.validateInput(dotimes));
		//System.out.println(example.validateInput(forl));
		//System.out.println(example.validateInput(make));
		//System.out.println(example.validateInput(to));
		//System.out.println(example.validateInput(ifelse)); //make sure of ifelse again
		//System.out.println(example.validateInput(ifl));
	}
	@Override
	protected void setSyntaxRegex() {
		// TODO Auto-generated method stub
		
	}	
}
