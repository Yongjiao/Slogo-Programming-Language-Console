package configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.regex.*;
/*
 *
 *TO DO: expression check
 *expr checked by using validateBasicCommands: like 1 > 5
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
	private final String[] command = new String[]{"fd", "forward", "back", "bk", "towards", "tw", "setxy", "sum", "+", "difference","-", "product","*",
			"quotient","remainder", "%", "/","#","left", "lt", "right", "rt", "setheading", "seth", "sin", "cos", "tan", "atan", "repeat", "dotimes","for",
			"if","ifelse", "to", "make", "set"};
	
	private final String[] regix = new String[]{ "^fd"+ onenum,"^foward" + onenum, "^back" +onenum, "^bk"+ onenum, "^towards"+twonum, "^tw" + twonum, "^setxy" + twonum,
			"^sum" + twonum, "^+" + twonum, "^difference"+ twonum, "^-" + twonum, "^product" + twonum, "^*" + twonum, "^quotient" + twonum,
			"^remainder" + twonum, "^%" + twonum, "^/" + twonum, "^#.*", "^left" +onenum,"^lt" +onenum, "^right" +onenum,"^rt" +onenum, "setheading" +onenum,
			"^seth" +onenum,"^sin" +onenum,"^cos" +onenum, "^tan" +onenum, "^atan" +onenum, "repeat"+onenum +com_regix, 
			"dotimes"+ "\\s\\["+variable+"\\s\\d+\\s\\]"+com_regix, "for \\[" + variable + twonum + onenum + "\\s\\]" + com_regix,
			"if" + ".*" + com_regix, "ifelse" + "\\s.*"+ com_regix + com_regix, "to "+commandname + "\\s\\[" + variable + "\\s\\]" + com_regix,
			"make" + variable + "\\s.*", "set" + variable + "\\s.*"};

	//non-nested command validation	
	public boolean validateBasicCommands(String regix, String in){
			return in.matches(regix);
			//call parser here.
	}
	public boolean validateBasicCommands(String in){
		String s = in.trim().toLowerCase();
		String command = s.split(" ")[0];
		//System.out.println(in);
		String commandRegix = commandMap.get(command);
		if(commandRegix != null){
			return s.matches(commandRegix);
		}
		return false;
	}
	public boolean validateInput(String in){
		String s = in.trim().toLowerCase();//sanitized input 
		String command = s.split(" ")[0];
		System.out.println(in);
		String commandRegix = commandMap.get(command);
		if(commandRegix != null){  //undefined commands
			if(userdefined.contains(command)){
				return validateLoop(commandRegix, s);	
			}
			else{
				return validateBasicCommands(commandRegix, s);
			}
		}
		return false;
	}
		
	
	public boolean validateLoop(String regix, String in){
		Pattern p = Pattern.compile(regix);
		Matcher m = p.matcher(in);		
		boolean result = false;
		while(m.find()){
			result = true;
			for(int i = 1; i <= m.groupCount(); i++){
				System.out.println(m.group(i));
				System.out.println(validateBasicCommands( m.group(i)));
				result = result && validateBasicCommands( m.group(i));
			}
			return result;
		}
		return result;
	}



	public ErrorCheck(){
	    String elements[] = { "ifelse", "if", "dotimes", "repeat", "for" };
		userdefined = new HashSet(Arrays.asList(elements));
		commandMap = new HashMap(); //what if new commands added
		for(int i=0; i < command.length; i++){
			commandMap.put(command[i],regix[i]);			
		}
	}

	public static void main(String[] args) {
		ErrorCheck example = new ErrorCheck();
		String s1 = "fd a";
		String s2= "sum 50 50";
		String s4 = "# ignore this is just comment!"; //broken when no space after #
		String s3 = "sum a b";
		String s5 = "REmainder 50 50";
		String s6 = " rt 50   ";
		String s7= "setheading 30";
		String repeat = "repeat 10 [ fd 50 ]";
		String dotimes = "dotimes [ :name 200 ] [ rt 50 ]";
		String forl = "for [ :v 0 10 1 ] [ lt 50 ]"; 
		String ifl = "if 1>5 [back 30]";
		String ifelse = "ifelse 4 > 5 [rt 50] [lt 100]";
		String set = "set :m [SUM 5 100]";
		String make = "make :n [% 30 40]";
		String to = "to line [ :va ] [ back 40 ]";
		//System.out.println(example.validateBasicCommands(s1));
		//System.out.println(example.validateBasicCommands(s2));
		//System.out.println(example.validateBasicCommands(s3));
		//System.out.println(example.validateBasicCommands(s4));
		//System.out.println(example.validateBasicCommands(s5));
		//System.out.println(example.validateBasicCommands(s6));
		//System.out.println(example.validateBasicCommands(s7));
		//System.out.println(example.validateInput(repeat));		
		//System.out.println(example.validateInput(dotimes));
		//System.out.println(example.validateInput(forl));
		//System.out.println(example.validateInput(ifl));
		//System.out.println(example.validateInput(make));
		//System.out.println(example.validateInput(to));
		System.out.println(example.validateInput(ifelse));
		
		
	}	
}
