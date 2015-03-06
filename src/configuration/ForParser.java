package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import application.CommandFactory;
import Tree.Node;
import configuration.NestedParser.Match;
import configuration.NestedParser.ParserError;
import configuration.NestedParser.TreeParser;

public class ForParser extends Configuration{
	private TreeParser tParser;
	
	public ForParser() throws IOException{
		initializeSyntax();		
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
		tParser = new TreeParser();
	}
	
	public double parse(String s) throws ParserError{
		Queue<String> tokens = toCommandQueue(s);
		System.out.println(tokens);
		skip(tokens);
		return parse(tokens);
	}
	
	private double parse(Queue<String> tokens) throws ParserError {
		int start, end, inc;
		double result = -1;
		if(!tokens.peek().matches(liststart))	
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		if(!tokens.peek().matches(variable))
			throw new ParserError("see" + tokens.poll() + "expected variable here!" );
		skip(tokens); //skip variable
		start = fetchConstant(tokens);
		end  = fetchConstant(tokens);
		inc = fetchConstant(tokens);
		if(!tokens.peek().matches(listend))	
			throw new ParserError("see" + tokens.poll() + "expected ] here!");
		skip(tokens);
		if(!tokens.peek().matches(liststart))
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		while(!isEnd(tokens) && !tokens.peek().matches(listend)){
			result = parseFor(start, end, inc, tokens);
		}
		if(isEnd(tokens) || !tokens.poll().matches(listend))
			throw new ParserError("Expected ] here !");
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;		
	}
	
	private int fetchConstant(Queue<String> qu) throws ParserError{
		if(!qu.peek().matches(constant))
			throw new ParserError("see" + qu.poll() + "expected number here!");
		return Integer.parseInt(qu.poll());
	}
	
	private double parseFor(int start, int end, int inc, Queue<String> qu) throws ParserError{
		double result = -1; //make more Treeparser.parse(Queue, String, int i);
		Node n = tParser.parse(qu);
		System.out.println("Tree parsed is " + n);
		for(int i = start; i < end; i++){
			result = n.getValue();		//execute tree for # iterations	
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException, ParserError {
		ForParser example = new ForParser();
		String forl =  "for [ :v 0 10 1 ] [ / sum 3 5 10 ]";
		example.parse(forl);
	}
}
