package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import Tree.Node;
import application.CommandFactory;
import configuration.NestedParser.Match;
import configuration.NestedParser.ParserError;
import configuration.NestedParser.TreeParser;

public class IfParser extends Parser{
	private final String comKey = "if";
	private TreeParser tParser;
	
	public IfParser() throws IOException{
		initializeSyntax();		
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
	}	
	@Override
	public double parse(String s){
		tParser = new TreeParser();
		Queue<String> tokens = toCommandQueue(s);
		skip(tokens);
		return parse(tokens);
	}
	/**
	 * @param command queue
	 * @return last executed command return value if boolean is evaluated to 0 
	 * @throws ParserError
	 */
	private double parse(Queue<String> tokens) throws ParserError {
		double result;
		String token = tokens.poll();
		if(!isboolean(token))	throw new ParserError("see " + token + "Expected boolean expression Here!");
		//double expr = tParser.parse(tokens).getValue();
		double expr = 1;
		tokens.poll();
		
		
		if(expr == 0)	return -1;
		if(!tokens.poll().matches(liststart))
			throw new ParserError("Expected token [ here !");
		//while(isListEnd()) 
		Node n = tParser.parse(tokens);
		System.out.println(n);
		result = n.getValue();
		if(!tokens.poll().matches(listend))
			throw new ParserError("Expected token ] here! ");
		if(!isEnd(tokens))
			throw new ParserError("Invalid Command, unnecesarily long for if statement");
		return result;
	}
	
	private boolean isboolean(String s){	
		String comKey = Match.findCommandKey(s, patterns);	
		return s.matches("LessThan|GreaterThan|Equal|NotEqual|And|Or|Not");
	}
	
	public static void main(String[] args) throws IOException, ParserError {
		// TODO Auto-generated method stub
		IfParser example = new IfParser();
		String ifl = "if 1 [ back 30 ]";
		example.parse(ifl);
	}

}
