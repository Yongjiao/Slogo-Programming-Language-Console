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
			 "\\s\\["+variable+onenum+"\\s\\]"+com_regix, "\\s\\[" + variable + twonum + onenum + "\\s\\]" + com_regix, boolean_regix + com_regix, 
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
	//if(com  != null)	com.execute();
}
	
private CommandFactory parseInput(String in) {
		String temp = in.trim().toLowerCase();//sanitized input 
		String[] comArray = temp.split(" ");
		String com = comArray[0];
		String commandRegex = commandMap.get(com);
		String s = temp.replaceFirst(com, "");		
		if(userdefined.contains(com)){
			return parseLoopCommands(s, commandRegex, com);	
		}
		else{
			return parseBasicCommand(s, commandRegex, com); //parse babsic command
		}		
	}
	private CommandFactory parseLoopCommands(String in, String regex, String com){
		int var = Integer.MAX_VALUE;
		ArrayList<CommandFactory> list = new ArrayList();
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(in);	
		System.out.println("Loop command is "+ com);
		switch(com){
			case "if":{	
				while(m.find()){
					int expr = parseInput(m.group(1)).execute(); //boolean expression
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
					System.out.println("iteration times = " +Integer.parseInt(m.group(1)));
					return new Repeat(Integer.parseInt(m.group(1)), list);
				}
			}
			case "dotimes":{
				while(m.find()){
					for(int i = 3; i <= m.groupCount(); i++){  
						list.add(parseInput(m.group(i).replaceAll(""+m.group(1), " "+ var))); //replace variable with 
					}
				System.out.println("variable is " + m.group(1));	
				System.out.println("limit = " + Integer.parseInt(m.group(2)));	
				return new DoTimes(Integer.parseInt(m.group(2)), list);
				}
			}
			case "ifelse":{
				int expr = 0;
				while(m.find()){
				 expr = parseInput(m.group(1)).execute(); //boolean expression
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
					for(int i = 5; i <= m.groupCount(); i++){  
						list.add(parseInput(m.group(i).replaceAll(m.group(1), " "+ var))); //replace variable with 
					}
					int start = Integer.parseInt(m.group(2));
					int end = Integer.parseInt(m.group(3));
					int inc = Integer.parseInt(m.group(4));
					System.out.println("variable = " + m.group(1)+ "    "+ "start, end, inc is "+ start+ " " + " "+ end+ " "+ inc+ " respectively");
					return new For(start, end, inc, list);
				}
			}

	}
		return null;
	}
	private CommandFactory parseBasicCommand(String in, String commandRegex, String com){	
		if(com.equals("home"))	return new Home();
		Pattern p = Pattern.compile(commandRegex);
		Matcher m = p.matcher(in);				
		//CommandFactory return = new CommandFactory();
		int[] par = new int[2];
		while(m.find()){
			for(int i = 1; i <= m.groupCount(); i++){
				par[i - 1]= Integer.parseInt(m.group(i));	
			}
		}
			System.out.println("Basic Command is " + com);
			System.out.println("Command "+com+" parameters is " + par[0] + " "+ par[1]);
			switch(com){
				case "forward": 	return new Forward(par[0]);
				case "back":		return new Backward(par[0]);
				case "towards":		return new GoTowardsLoc(5, 4);
				case "setxy":		return new GoToLocation(par[0], par[1]);
				case "sum":			return new Add(par[0], par[1]);
				case "difference":	return new Subtract(par[0], par[1]);
				case "product":		return new Multiply(par[0], par[1]);
				case "quotient":	return new Divide(par[0] , par[1]);
				case "remainder":	return new Remainder(par[0], par[1]);
				//case "#":			
				case "left":		return new Left(par[0]);
				case "right":		return new Right(par[0]);
				case "setheading":	return new SetHeading(par[0]);
				case "sin":			return new Sin(par[0]);
				case "cos":			return new Cos(par[0]);
				case "tan":			return new Tan(par[0]);
				case "atan":		return new ATan(par[0]);
				case "less?":		return new Less(par[0], par[1]);
				case "greater?":	return new Greater(par[0], par[1]);
				case "equal?":		return new Equal(par[0], par[1]);
				
		}	
		return null;
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
		String s1 = "fd 1";
		String s2= "sum 50 50";
		String s4 = "# ignore this is just comment!"; //broken when no space after #
		String s3 = "sum a b";
		String s5 = "REmainder 50 50";
		String s6 = " rt 50   ";
		String s7= "setheading 30";
		String repeat = "repeat 10 [ fd 50 ]";
		String dotimes = "dotimes [ :name 200 ] [ rt :name ]";
		String forl = "for [ :v 0 10 1 ] [ lt 50 ]"; 
		String ifl = "if less? 1 5 [back 30]";
		String ifelse = "ifelse greater? 2 6 [rt 50] [lt 100]";
		String set = "set :m [SUM 5 100]";
		String make = "make :n [% 30 40]";//change to set
		String to = "to line [ :va ] [ back 40 ]";		
		System.out.println(forl);
		example.parse(forl);
		// TODO Auto-generated method stub
//add set/make/to 
//check if/ifelse
	}

}
