package configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.CommandFactory;
import commands.*;
public class Parser {
	private HashMap<String, String> commandMap;
	private HashSet<String> userdefined;
	private final String onenum = "\\s(\\d+)"; //one parameter only exactly one space between parameters
	private final String twonum = "\\s(\\d+)\\s(\\d+)";	//two parameter
	private final String com_regix = "\\s\\[(.*?)\\]"; //[command]
	private final String variable = "\\s(:\\w+)";
	private final String constant = "-?\\d+.?\\d*";
	private final String commandname = "\\w+[?]?";	
	private final String boolean_regix = "\\s(less\\?\\s\\d+\\s\\d+| greater\\?\\s\\d+\\s\\d+ | euqal\\?\\s\\d+\\s\\d+)";
	
	private final String[] command = new String[]{"fd", "forward", "back", "bk", "towards", "tw", "setxy", "sum", "+", "difference","-", "product","*",
			"quotient","remainder", "%", "/","#","left", "lt", "right", "rt", "setheading", "seth", "sin", "cos", "tan", "atan", "repeat", "dotimes","for",
			"if","ifelse", "to", "make", "set","less?", "greater?", "equal?"};
	
	private final String[] regix = new String[]{ onenum, onenum, onenum,  onenum, twonum,  twonum, twonum, twonum, twonum,  twonum,  twonum, twonum,
			twonum, twonum, twonum,  twonum, twonum, ".*",onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum +com_regix, 
			 "\\s\\["+variable+"\\s\\d+\\s\\]"+com_regix, "\\s\\[" + variable + twonum + onenum + "\\s\\]" + com_regix, boolean_regix + com_regix, 
			 boolean_regix  + com_regix + com_regix, "\\s" + commandname + "\\s\\[" + variable + "\\s\\]" + com_regix, variable + "\\s.*", variable + "\\s.*",
			 twonum,  twonum, twonum};
	
	
/*	public void parse(String in) {
		String s = in.trim().toLowerCase();//sanitized input 
		String command = s.split(" ")[0];
		String commandRegix = commandMap.get(command);
		if(userdefined.contains(command)){
				
		}
		else{
			parseBasicCommand(commandRegix, s); //parse babsic command
		}
		
		
	}
	//loop commands needs to check in map for sure
*/
	
	public void parseBasicCommand(String in){
		//can do in many ways
		String temp = in.trim().toLowerCase();//sanitized input 
		String[] comArray = temp.split(" ");
		String com = comArray[0];
		String regex = commandMap.get(command);
		String s = temp.replaceFirst(com, "");		
		//set parameter of the object using either one/two parameter
		//execute();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);		
		CommandFactory command;
		
		while(m.find()){
			ArrayList<Integer> par = new ArrayList<>();
			for(int i = 1; i <= m.groupCount(); i++){
				par.add(Integer.parseInt(m.group(i)));	
			}
			switch(com){
			case "forward": 	command = new Forward(par.get(0));
			case "back":		command = new Backward(par.get(0));
			case "towards":		command = new GoTowardsLoc(par.get(0), par.get(1));
			case "setxy":		command = new GoToLocation(par.get(0), par.get(1));
			case "sum":			command = new Add(par.get(0), par.get(1));
			case "difference":	command = new Subtract(par.get(0), par.get(1));
			case "product":		command = new Multiply(par.get(0), par.get(1));
			case "quotient":	command = new Divide(par.get(0) , par.get(1));
			case "remainder":	command = new Remainder(par. get(0), par.get(1));
			//case "#":			
			case "left":		command = new Left(par.get(0));
			case "right":		command = new Right(par.get(0));
			case "setheading":	command = new SetHeading(par.get(0));
			case "sin":			command = new Sin(par.get(0));
			case "cos":			command = new Cos(par.get(0));
			case "tan":			command = new Tan(par.get(0));
			case "atan":		command = new ATan(par.get(0));
			case "less?":		command = new Less(par.get(0), par.get(1));
			case "greater?":	command = new Greater(par.get(0), par.get(1));
			case "equal?":		command = new Equal(par.get(0), par.get(1));
			//case "Home":		command = new Home();
			//case  ""
			}
			command.execute();
		}

/*			if(regex.equals(onenum)){				
				//set parameters CommandFactory.execute(String.valueOf(group(1)));
			}			
			else if(regex.equals(twonum)){	
				//set two parameters and execute CommandFatory.execute(String.valueOf(group(1)), String.valueOf(group(2)))
			}	
*/			
			//CommandFactory.execute();		
	}
		
		
	public CommandFactory parse(Boolean ifs){
		
		return null;
	}
	
	
	public static void main(String[] args) {
		Parser example = new Parser();
		String s = "fd 50";
		example.parseBasicCommand();
		// TODO Auto-generated method stub

	}

}
