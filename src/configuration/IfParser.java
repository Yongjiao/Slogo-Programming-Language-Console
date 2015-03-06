package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import Tree.Node;
import application.CommandFactory;
import configuration.NestedParser.Match;
import configuration.NestedParser.ParserError;
import configuration.NestedParser.TreeParser;

public class IfParser extends Configuration{
	private final String comKey = "if";
	private TreeParser tParser;
	
	public IfParser() throws IOException{
		initializeSyntax();		
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
	}	

	public double parse(String s) throws IOException, ParserError{
		tParser = new TreeParser();
		Queue<String> tokens = toCommandQueue(s);
		System.out.println(tokens);
		skip(tokens);
		return parse(tokens);
	}
	/**
	 * @param command queue
	 * @return last executed command return value if boolean is evaluated to 0 
	 * @throws ParserError
	 */
	private double parse(Queue<String> tokens) throws ParserError {
		double result = -1;
		String token = tokens.peek();
		if(!isboolean(token))	throw new ParserError("see " + token + "Expected boolean expression Here!");
		double expr = tParser.parse(tokens).getValue();
		if(expr == 0)	return -1;
		System.out.println(expr);
		if(!tokens.poll().matches(liststart))
			throw new ParserError("Expected token [ here !");
		while(!isEnd(tokens) && !tokens.peek().matches(listend)){
			Node n = tParser.parse(tokens);
			System.out.println("Tree parsed is " + n);
			result = n.getValue();
		}
		if(isEnd(tokens) || !tokens.poll().matches(listend))
			throw new ParserError("Expected ] here !");
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;
	}

	private boolean isboolean(String s){	
		String comKey = Match.findCommandKey(s, patterns);
		return comKey.matches("(LessThan|GreaterThan|Equal|NotEqual|And|Or|Not)");
	}
	
	public static void main(String[] args) throws IOException, ParserError {
		// TODO Auto-generated method stub
		IfParser example = new IfParser();
		String ifl = "if equal? 6 6 [ * 30 20 / 20 10 ]";
		example.parse(ifl);
	}
	
}
