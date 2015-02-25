package configuration;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	private final String[] commands = new String[]{"fd", "forward", "back", "bk", "towards", "tw", "setxy", "sum", "+", "difference","-", "product","*",
			"quotient","remainder", "%", "/","#","left", "lt", "right", "rt", "setheading", "seth", "sin", "cos", "tan", "atan", "repeat", "dotimes","for",
			"if","ifelse", "to", "make", "set","less?", "greater?", "equal?"};
	
	private final String[] regix = new String[]{ onenum, onenum, onenum,  onenum, twonum,  twonum, twonum, twonum, twonum,  twonum,  twonum, twonum,
			twonum, twonum, twonum,  twonum, twonum, ".*",onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum +com_regix, 
			 "\\s\\["+variable+"\\s\\d+\\s\\]"+com_regix, "\\s\\[" + variable + twonum + onenum + "\\s\\]" + com_regix, boolean_regix + com_regix, 
			 boolean_regix  + com_regix + com_regix, "\\s" + commandname + "\\s\\[" + variable + "\\s\\]" + com_regix, variable + "\\s.*", variable + "\\s.*",
			 twonum,  twonum, twonum};

/*			if(regex.equals(onenum)){				
				//set parameters CommandFactory.execute(String.valueOf(group(1)));
			}			
			else if(regex.equals(twonum)){	
				//set two parameters and execute CommandFatory.execute(String.valueOf(group(1)), String.valueOf(group(2)))
			}	
*/			

public void parse(String in){		
	CommandFactory com =  parseInput(in);
	if(com  != null)	com.execute();
}
	
public CommandFactory parseInput(String in) {
		String temp = in.trim().toLowerCase();//sanitized input 
		String[] comArray = temp.split(" ");
		String com = comArray[0];
		System.out.println(com);
		String commandRegex = commandMap.get(com);
		String s = temp.replaceFirst(com, "");		

		Pattern p = Pattern.compile(commandRegex);
		Matcher m = p.matcher(s);
		if(userdefined.contains(com)){
			return parseLoopCommands(s, commandRegex, com);	
		}
		else{
			return parseBasicCommand(s); //parse babsic command
		}		
	}
	public CommandFactory parseLoopCommands(String in, String regex, String com){
		int var = Integer.MAX_VALUE;
		ArrayList<CommandFactory> list = new ArrayList();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(in);	
		switch(com){
			case "if":{	
				while(m.find()){
					int expr = parseBasicCommand(m.group(1)).execute(); //boolean expression
					if(expr == 1)
					for(int i = 2; i <= m.groupCount(); i++){
						list.add(parseInput(m.group(i)));
						//System.out.println(m.group(i));
					}
					return new IfCond(expr, list);	
			}
			}
			case "repeat":{
				while(m.find()){
					for(int i = 2; i <= m.groupCount(); i++){
						list.add(parseInput(m.group(i)));
					}
					return new Repeat(Integer.parseInt(m.group(1)), list);
				}
			}
			case "dotimes":{
				while(m.find()){
					for(int i = 2; i <= m.groupCount(); i++){  
						list.add(parseInput(m.group(i).replaceAll(variable, " "+ var))); //replace variable with 
					}
				}
			}
			case "ifelse":{
				int expr = 0;
				while(m.find()){
				 expr = parseBasicCommand(m.group(1)).execute(); //boolean expression
					if(expr == 0)
						for(int i = 2; i <= m.groupCount(); i++){ //m.group(2) is if and m.group(3) is elses 
							list.add(parseInput(m.group(i)));
						}
					if(expr ==1)
						for(int i = 3; i <= m.groupCount(); i++){
							list.add(parseInput(m.group(i)));
						}
				}
				return new IfCond(expr, list);
			}
			case "for":{ //first 3 is int
				while(m.find()){
					for(int i = 4; i <= m.groupCount(); i++){  
						list.add(parseInput(m.group(i).replaceAll(variable, " "+ var))); //replace variable with 
					}
					int start = Integer.parseInt(m.group(1));
					int end = Integer.parseInt(m.group(2));
					int inc = Integer.parseInt(m.group(3));
					return new For(start, end, inc, list);
				}
			}

	}
		return null;
	}
	public CommandFactory parseBasicCommand(String in){
		//can do in many ways
		String temp = in.trim().toLowerCase();//sanitized input 
		String[] comArray = temp.split(" ");
		String com = comArray[0];
		System.out.println(com);
		String regex = commandMap.get(com);
		String s = temp.replaceFirst(com, "");		
		//set parameter of the object using either one/two parameter
		//execute();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);		
		
		CommandFactory command = new CommandFactory();
		int[] par = new int[2];
		while(m.find()){
			for(int i = 1; i <= m.groupCount(); i++){
				par[i - 1]= Integer.parseInt(m.group(i));	
			}
		}
			System.out.println(par[0] + " "+ par[1]);
			switch(com){
				case "forward": 	command = new Forward(par[0]);
									break;
				case "back":		command = new Backward(par[0]);
									break;
				case "towards":		command = new GoTowardsLoc(5, 4);
				case "setxy":		command = new GoToLocation(par[0], par[1]);
				case "sum":			command = new Add(par[0], par[1]);
				case "difference":	command = new Subtract(par[0], par[1]);
				case "product":		command = new Multiply(par[0], par[1]);
				case "quotient":	command = new Divide(par[0] , par[1]);
				case "remainder":	command = new Remainder(par[0], par[1]);
				//case "#":			
				case "left":		command = new Left(par[0]);
				case "right":		command = new Right(par[0]);
				case "setheading":	command = new SetHeading(par[0]);
				case "sin":			command = new Sin(par[0]);
				case "cos":			command = new Cos(par[0]);
				case "tan":			command = new Tan(par[0]);
				case "atan":		command = new ATan(par[0]);
				case "less?":		command = new Less(par[0], par[1]);
				case "greater?":	command = new Greater(par[0], par[1]);
				case "equal?":		command = new Equal(par[0], par[1]);
				//case  ""
				//case "Home":		command = new Home();
			}
			//command.execute();
			return command;
		}		
		

	public Parser(){
	    String elements[] = { "ifelse", "if", "dotimes", "repeat", "for" };
		userdefined = new HashSet(Arrays.asList(elements));
		commandMap = new HashMap(); //what if new commands added
		for(int i=0; i < commands.length; i++){
			commandMap.put(commands[i],regix[i]);			
		}
	}
	
	public static void main(String[] args) {
		Parser example = new Parser();
		String s = "sin 50";
		example.parseBasicCommand(s);
		// TODO Auto-generated method stub

	}

}
