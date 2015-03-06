package configuration;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.*;

import commands.Set;
import configuration.NestedParser.Match;
import configuration.NestedParser.ParserError;
import configuration.NestedParser.TreeParser;
import Tree.BinNode;
import Tree.ConstNode;
import Tree.Node;
import Tree.SingleNode;
import application.CommandFactory;

/**
 * A subclass dedicated only for set command parsing
 * @author Yongjiao Yu
 *
 */
public class SetParser extends Parser{
	private final String comKey = "makevariable";
	private TreeParser tParser;
	
	public SetParser() throws IOException{
		initializeSyntax();		
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
	}
	/*@Override
	CommandFactory parse(String in ){
		return parseInput(in);  //not sure if will call the correct one
	}
	*/
	@Override
	public double parse(String s){
		tParser = new TreeParser();
		Queue<String> tokens = toCommandQueue(s);
		/* ?throw errors if comKey is not makevariable
		 * if(Match.findCommandKey(tokens.poll(), patterns); 
		 */
		skip(tokens);
		CommandFactory com = parse(tokens);	
		return com.execute();	
	}
	//can just execute() and change to double but keep for ease of debugging
	private CommandFactory parse(Queue<String> tokens) throws ParserError {
		String token = tokens.poll();			
		if(!token.matches(variable)){
			throw new ParserError("Expected Variable here!");
		}
		double val = tParser.parse(tokens).getValue();
		ArrayList<Object> par = new ArrayList<>();
		par.add(val);
		System.out.println("set parameter is " + par);
		if(!isEnd(tokens))	
			throw new ParserError("Too many commands for Set command!");
		return new Set(token, par);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
