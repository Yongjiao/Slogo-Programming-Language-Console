package configuration;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import application.CommandFactory;
import commands.*;
import configuration.NestedParser.TreeParser;

/**
 * Parses and initiates execution of commands
 * @author Yongjiao Yu
 *
 */
public class Parser extends Configuration{
	private HashMap<String, String> commandMap;
	private Validator myErrorCheck;
	private HashMap<String, Parser> myParsers;	
//simplify Parser's regex by inheritance, no need for regex for basic commands	
	protected final String onenum = "\\s(\\d+)"; //one parameter only exactly one space between parameters	
	protected final String twonum = "\\s(\\d+)\\s(\\d+)";	//two parameter
	protected final String com_regex = "\\s\\[(.*?)\\s\\]"; //[command]
	protected final String variable = "\\s(:\\w+)";
	protected final String constant = "-?\\d+.?\\d*";
	protected final String commandname = "\\w+[?]?";	
	protected final String boolean_regex = "\\s(less\\?\\s\\d+\\s\\d+|greater\\?\\s\\d+\\s\\d+|equal\\?\\s\\d+\\s\\d+)";
	
	private final String[] regex = new String[]{ onenum, onenum,  twonum, twonum, twonum, twonum,  twonum, twonum,
			 twonum,  ".*",onenum, onenum, onenum, onenum, onenum, onenum, onenum, onenum +com_regex, 
			 "\\s\\["+variable+onenum+"\\s\\]"+com_regex, "\\s\\[" + variable + twonum + onenum + "\\s\\]" + com_regex, boolean_regex + com_regex, 
			 boolean_regex  + com_regex + com_regex, "\\s" + commandname + "\\s\\[" + variable + "\\s\\]" + com_regex, variable + "\\s.*", variable + "\\s.*",
			 twonum,  twonum, twonum, twonum, variable + onenum, twonum};
	
	
	public Parser(){
		myErrorCheck = new Validator(); 
		initialize();
		//initializeParsers();	
		commandMap = initializeCommandMap(commands, regex);
	}	
	private void initializeParsers(){
		myParsers = new HashMap<>();
		myParsers.put("makevariable", new SetParser());
		//myParsers.put("basic", new TreeParser());
		//myParsers.put("if", new IfParser());
		//myParsers.put("ifelse", new IfelseParser());
		//myParsers.put("repeat", new RepeatParser());
		//myParsers.put("dotimes", new DotimesParser());
		//myParsers.put("for", new ForParser());
	}
	public void validateAndParse(String in){	
		System.out.println(in);
		CommandFactory com = null;
		if(myErrorCheck.validateInput(in)){
			System.out.println("-------------Validation passed-------------");
			com =  parse(in);
		}
		else	System.out.println("Throw an error! Invalid input format");
		if(com  != null)	com.execute();
	}
	
	protected CommandFactory parse(String in ){
		System.out.println(in);
		return parseInput(in);
	}
	
private CommandFactory parseInput(String in) {
		String s = in.trim().toLowerCase();//sanitized input 
		String command = s.split(" ")[0];		
		String comKey = lanMap.get(command); 
		String temp = command;
		if(comKey == null){ //traverse to find the correct ComKey, has to have one since already validated
			for(String k: lanMap.keySet()){
				if(command.matches(k)){
					comKey = lanMap.get(k);
					temp = k;
				}				
			}
		}
		String commandRegex = commandMap.get(comKey);		
		s = s.replaceFirst(temp, ""); //use keyRegex to remove it
		
		if(userdefined.contains(comKey)){   //entire part could be extract out for commandMaker and execute.
			switch(comKey){
				case "makevariable": 
					return myParsers.get(comKey).parse(in);
				case "if":
					return myParsers.get(comKey).parse(in);
				case "repeat":
					return myParsers.get(comKey).parse(in);
				case "dotimes":
					return myParsers.get(comKey).parse(in);
			}
			
			return parseLoopCommands(s, commandRegex, comKey);	
		}
		else{
			CommandFactory c = CommandMaker.makeNoParmsCommands(comKey);
			if( c != null)		return c;
			TreeParser tParser= myParsers.get("basic");
			tParser.parse(in);//return void
			return null; //!!! unify the return type later
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
					System.out.println("Booean is evaluted to " + expr);
					if(expr == 1){ //no object created when expr is evaluated to 0
					for(int i = 2; i <= m.groupCount(); i++){
						list.add(parseInput(m.group(i)));
					}		
					return new IfCond(expr, list);	
					}
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
				 System.out.println("Boolean expression evaluates to " + expr);
					if(expr == 1)
						for(int i = 2; i <= m.groupCount(); i++){ //m.group(2) is if and m.group(3) is elses 
							list.add(parseInput(m.group(i)));
						}
					else if(expr == 0)
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
/*
	//could be replaced by using Treeparser.parse(in). NO COMMAND REGEX NEEDED
	private CommandFactory parseBasicCommand(String in, String commandRegex, String com){	
		CommandFactory c = CommandMaker.makeNoParmsCommands(com);
		if( c != null)		return c;
		Pattern p = Pattern.compile(commandRegex);
		Matcher m = p.matcher(in);				
		ArrayList<Object> par = new ArrayList<>();
		while(m.find()){
			for(int i = 1; i <= m.groupCount(); i++){
				par.add(Double.parseDouble(m.group(i)));	
			}
			System.out.println("Basic Command is " + com);
			System.out.println("Command "+com+" parameters is " + par);
			return CommandMaker.makeBasicCommands(com, par);
		}	
		return null;
	}
<<<<<<< HEAD
	*/
=======
	//no parameters
	private CommandFactory createCommands(String com){
		switch(com){
			case "home":		    	return new Home();
			case "pendown":  			return new PenDown();
			case "penup": 				return new PenUp();
			case "clearscreen":			return new ClearScreen();
			case "showturtle":			return new ShowTurtle();
			case "hideturtle":			return new HideTurtle();
			case "ispendown":			return new IsPD();
			case "isshowing":			return new Showing();
			case "heading":				return new Heading();
			case "xcoordinate":			return new XCor();
			case "ycoordinate":			return new YCor();
		}
		return null;
	}
	private CommandFactory createBasicCommands(String com, int[] par){
	switch(com){
		case "forward": 		return new Forward(par[0]);
		case "backward":		return new Backward(par[0]);
		case "settowards":		return new GoTowardsLoc(5, 4);
		case "setxy":			return new GoToLocation(par[0], par[1]);
		case "sum":				return new Add(par[0], par[1]);
		case "difference":		return new Subtract(par[0], par[1]);
		case "product":			return new Multiply(par[0], par[1]);
		case "quotient":		return new Divide(par[0] , par[1]);
		case "remainder":		return new Remainder(par[0], par[1]);
		//case "#":
		case "left":			return new Left(par[0]);
		case "right":			return new Right(par[0]);
		case "setheading":		return new SetHeading(par[0]);
		case "sine":			return new Sin(par[0]);
		case "cosine":			return new Cos(par[0]);
		case "tangent":			return new Tan(par[0]);
		case "arctangent":		return new ATan(par[0]);
		case "lessthan":		return new Less(par[0], par[1]);
		case "greaterthan":		return new Greater(par[0], par[1]);
		case "equal":			return new Equal(par[0], par[1]);		
		}
		return null;	
	}
	
>>>>>>> 1d63a1810aa0f4099fd3e71b9ceac6b5fd5aadc7
	public void changeLanguage(ResourceBundle r){
		myErrorCheck.setLanguage(r);
		setLanguage(r); //if use super.language, will initialize the lanMap in superclass.
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
		String forl = "for [ :v 0 10 1 ] [ sum 3 5 ]"; 
		String ifl = "if less? 1 5 [ back 30 ]";
		String ifelse = "ifelse equal? 2 6 [ rt 50 ] [ lt 50 ]";
		String set = "set :m [ SUM 5 100 ]";
		String make = "make :n [ % 30 40 ]";//change to set
		String to = "to line [ :va ] [ back 40 ]";		
		//System.out.println(repeat);
		example.parse(ifl);
		//set, make, to have not yet been implemented
	}

	@Override
	protected void setSyntaxRegex() {
		// TODO Auto-generated method stub
		
	}

}
