package configuration;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import application.CommandFactory;
import commands.CommandCenter;
import Tree.*;

/**
 * Parses Command of any kind
 * @author Yongjiao Yu
 *
 */
public class BasicParser extends Parser{
	private HashMap<String, Parser> myParsers;		
	private HashSet<String> userdefined;
	private CommandFactory myFactory;
	
	public BasicParser() throws IOException{
		myFactory = new CommandFactory();
		initializeParsers();
	}	
	/**
	 * parses command according to command type
	 * @param user input
	 * @return return value of the last executed command
	 */
	public double parse(String s) throws ParserError, IOException{
		String comKey;
		double result = -1;
		Queue<String> tokens = Util.toCommandQueue(s);
		String command = tokens.peek();
		comKey = Util.findCommandKey(tokens.peek(), super.getPatterns());
		CommandCenter com = myFactory.makeNoParmsCommands(comKey);
		if(com != null)	return com.execute();
		System.out.println(comKey);
		if(userdefined.contains(comKey)){
			return myParsers.get(comKey).parse(s);
		}
		else{
			result = parse(tokens);
		}
		return result;			
	}
	/**
	 * parses basic (nested) commands, allows only one full command/tree
	 * @param  input command in string form
	 * @return the result of the last executed commands (if nested)
	 * @throws ParserError
	 */
	public double parse(Queue<String> qu) throws ParserError{
		ArrayList<Node> roots = new ArrayList<Node>(); //dont really need the arrayList of node
		double result = -1;
		Node expRoot = buildTree(qu);			
		System.out.println("The full comamnd parsed is " + expRoot);
		if(expRoot.hasChild() == 0) 		
			throw new ParserError("Additional numeric tokens: " + expRoot.getValue());
		result = expRoot.getValue();
		System.out.println("a tree parsed is evaluated to " + result);
		roots.add(expRoot);
		System.out.println();
		return result;
	}
	private void initializeParsers() throws IOException{
		String elements[] = { "MakeVariable", "IfElse", "If", "DoTimes", "Repeat", "For"};
		Parser[] pars = {new SetParser(), new IfelseParser(), new IfParser(), new DotimesParser(), new RepeatParser(),new ForParser()};
		myParsers = new HashMap<>();
		userdefined = new HashSet(Arrays.asList(elements));
		for(int i = 0; i < elements.length; i++){
			myParsers.put(elements[i], pars[i]);
		}
	}
	@Override
	public void setLanguage(String path){
		super.setLanguage(path);
	}	

}
