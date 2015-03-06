package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import Tree.Node;
import configuration.NestedParser.Match;
import configuration.NestedParser.ParserError;
import configuration.NestedParser.TreeParser;
/**
 * subclass for Dotimes command parsing
 * @author Yongjiao Yu
 *
 */
public class DotimesParser extends Configuration{
	private TreeParser tParser;
	
	public DotimesParser() throws IOException{
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
		double result = -1;
		int limit = 0;
		if(!tokens.peek().matches(liststart))	
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		if(!tokens.peek().matches(variable))
			throw new ParserError("see" + tokens.poll() + "expected variable here!" );
		skip(tokens); //skip variable
		limit = fetchConstant(tokens);
		if(!tokens.peek().matches(listend))	
			throw new ParserError("see" + tokens.poll() + "expected ] here!");
		skip(tokens);
		//
		if(!tokens.peek().matches(liststart))
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		while(!isEnd(tokens) && !tokens.peek().matches(listend)){
			result = parseFor(1, limit, 1, tokens);
		}
		if(isEnd(tokens) || !tokens.poll().matches(listend))
			throw new ParserError("Expected ] here !");
		//
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
		DotimesParser example = new DotimesParser();
		String dotimes = "dotimes [ :name 200 ] [ sin 300  atan 100 ]";
		example.parse(dotimes);
	}

}
