package configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.regex.*;
/*
 * To Do: language change
 expression check
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
	private final String boolean_regix = "\\s(less\\?\\s\\d+\\s\\d+| greater\\?\\s\\d+\\s\\d+ | euqal\\?\\s\\d+\\s\\d+)";
	private final String[] command = new String[]{"fd", "forward", "back", "bk", "towards", "tw", "setxy", "sum", "+", "difference","-", "product","*",
			"quotient","remainder", "%", "/","#","left", "lt", "right", "rt", "setheading", "seth", "sin", "cos", "tan", "atan", "repeat", "dotimes","for",
			"if","ifelse", "to", "make", "set","less?", "greater?", "equal?"};
	
	private final String[] regix = new String[]{ "^fd"+ onenum,"^foward" + onenum, "^back" +onenum, "^bk"+ onenum, "^towards"+twonum, "^tw" + twonum, "^setxy" + twonum,
			"^sum" + twonum, "^+" + twonum, "^difference"+ twonum, "^-" + twonum, "^product" + twonum, "^*" + twonum, "^quotient" + twonum,
			"^remainder" + twonum, "^%" + twonum, "^/" + twonum, "^#.*", "^left" +onenum,"^lt" +onenum, "^right" +onenum,"^rt" +onenum, "setheading" +onenum,
			"^seth" +onenum,"^sin" +onenum,"^cos" +onenum, "^tan" +onenum, "^atan" +onenum, "repeat"+onenum +com_regix, 
			"dotimes"+ "\\s\\["+variable+"\\s\\d+\\s\\]"+com_regix, "for \\[" + variable + twonum + onenum + "\\s\\]" + com_regix,
			"if" + boolean_regix + com_regix, "ifelse" + boolean_regix  + com_regix + com_regix, "to "+commandname + "\\s\\[" + variable + "\\s\\]" + com_regix,
			"make" + variable + "\\s.*", "set" + variable + "\\s.*", "less\\?"+ twonum, "greater\\?" + twonum, "equal\\?" + twonum};
	
	//non-nested command validation	
	public boolean validateBasicCommands(String regex, String in){
			//System.out.println(in);
		    //System.out.println(in.matches(regex));
			return in.matches(regex);
			//call parser here.
	}
/*	public boolean validateBasicCommands(String in){
		String s = in.trim().toLowerCase();
		String command = s.split(" ")[0];
		//System.out.println(in);
		String commandRegix = commandMap.get(command);
		if(commandRegix != null){
			return s.matches(commandRegix);
		}
		return false;
	}
	*/
	public boolean validateInput(String in){ 
		String s = in.trim().toLowerCase();//sanitized input 
		String command = s.split(" ")[0];
		System.out.println(in);
		String commandRegix = commandMap.get(command);
		if(commandRegix != null){  //undefined commands
			if(userdefined.contains(command)){
				return validateLoop(commandRegix, s);	
			}
			else
				return validateBasicCommands(commandRegix, s);
		}
		return false;
	}		

	public boolean validateLoop(String regix, String in){
		Pattern p = Pattern.compile(regix);
		Matcher m = p.matcher(in);		
		while(m.find()){
			for(int i = 1; i <= m.groupCount(); i++){
				//System.out.println(m.group(i));
				//System.out.println(validateInput( m.group(i)));
				if(!validateInput(m.group(i)))	return false;
			}
			return true;
		}
		return false;
	}

	public ErrorCheck(){
		//setProperties() ResourceBundle()
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
		String ifl = "if less? 1 5 [back 30]";
		String ifelse = "ifelse greater? 2 6 [rt 50] [lt 100]";
		String set = "set :m [SUM 5 100]";
		String make = "make :n [% 30 40]";//change to set
		String to = "to line [ :va ] [ back 40 ]";
		//System.out.println(example.validateInputCommands(s1));
		//System.out.println(example.validateInputCommands(s2));
		//System.out.println(example.validateInputCommands(s3));
		//System.out.println(example.validateInputCommands(s4));
		//System.out.println(example.validateInputCommands(s5));
		//System.out.println(example.validateInputCommands(s6));
		//System.out.println(example.validateInputCommands(s7));
		//System.out.println(example.validateInput(repeat));		
		//System.out.println(example.validateInput(dotimes));
		//System.out.println(example.validateInput(forl));
		//System.out.println(example.validateInput(make));
		//System.out.println(example.validateInput(to));
		//System.out.println(example.validateInput(ifelse));
		System.out.println(example.validateInput(ifl));
	}	
}
