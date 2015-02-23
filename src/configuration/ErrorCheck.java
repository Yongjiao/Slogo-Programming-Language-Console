package configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;

public class ErrorCheck {
	private HashMap<String, String> commandMap;
	private final String onenum = "\\s\\d+"; //one parameter only exactly one space between parameters
	private final String twonum = "\\s\\d+\\s\\d+";	//two parameter
	private final String com_regix = "\\[(.*?)\\]"; //[command]
	private final String variable = ":\\w+";
	private final String constant = "-?\\d+.?\\d*";
	private final String commandname = "\\w+[?]?";	
	private final String[] command = new String[]{"fd", "forward", "back", "bk", "towards", "tw", "setxy", "sum", "+", "difference","-", "product","*",
			"quotient","remainder", "%", "/","#","left", "lf", "right", "rt", "setheading", "seth", "sin", "cos", "tan", "atan", "repeat", "dotimes"};
	
	private final String[] regix = new String[]{ "^fd"+ onenum,"^foward" + onenum, "^back" +onenum, "^bk"+ onenum, "^towards"+twonum, "^tw" + twonum, "^setxy" + twonum,
			"^sum" + twonum, "^+" + twonum, "^difference"+ twonum, "^-" + twonum, "^product" + twonum, "^*" + twonum, "^quotient" + twonum,
			"^remainder" + twonum, "^%" + twonum, "^/" + twonum, "^#.*", "^left" +onenum,"^lt" +onenum, "^right" +onenum,"^rt" +onenum, "setheading" +onenum,
			"^seth" +onenum,"^sin" +onenum,"^cos" +onenum, "^tan" +onenum, "^atan" +onenum, "repeat"+onenum+"\\s" +com_regix, 
			"dotimes"+ "\\s\\[\\s"+variable+"\\s\\d+\\s\\]\\s"+com_regix};
	
/*
	public boolean validateInput(String in){
		String s = in.trim().toLowerCase();
		String command = s.split(" ")[0];	
		System.out.println(in);		
	}
*/

	//non-nested command validation	
	public boolean validateBasicCommands(String in){
		String s = in.trim().toLowerCase();
		String command = s.split(" ")[0];
		System.out.println(in);
		String commandRegix = commandMap.get(command);
		if(commandRegix != null){
			return s.matches(commandRegix);
			//call parser here.
		}
		return false;
	}
	public boolean validateInput(String in){
		String s = in.trim().toLowerCase();//sanitized input 
		String command = s.split(" ")[0];
		System.out.println(in);
		String commandRegix = commandMap.get(command);
		if(commandRegix != null){  //undefined commands
			return validateLoop(commandRegix, s);			
		}
		return false;
	}
	
	public boolean validateLoop(String regix, String in){
		Pattern p = Pattern.compile(regix);
		Matcher m = p.matcher(in);		
		while(m.find())
			return validateBasicCommands(m.group(1));
		return false;
	}



	public ErrorCheck(){
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
		//System.out.println(example.validateBasicCommands(s1));
		//System.out.println(example.validateBasicCommands(s2));
		//System.out.println(example.validateBasicCommands(s3));
		//System.out.println(example.validateBasicCommands(s4));
		//System.out.println(example.validateBasicCommands(s5));
		//System.out.println(example.validateBasicCommands(s6));
		//System.out.println(example.validateBasicCommands(s7));
		System.out.println(example.validateInput(repeat));		
		//System.out.println(example.validateInput(dotimes));
	}	
}
