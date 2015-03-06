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

public class RepeatParser extends Configuration{
	private TreeParser tParser;
	
	public RepeatParser() throws IOException{
		initializeSyntax();		
		patterns = new ArrayList<Entry<String, Pattern>>();
        patterns.addAll(Match.makePatterns("resources/languages/English"));
		tParser = new TreeParser();
	}
	public double parse(String s) throws IOException, ParserError{
		Queue<String> tokens = toCommandQueue(s);
		System.out.println(tokens);
		skip(tokens);
		return parse(tokens);
	}
	
	private double parse(Queue<String> tokens) throws ParserError {
		double result = -1;
		Node expr = tParser.parse(tokens); //can be a numeric node
		int iter = (int) expr.getValue();
		//comment parse start from here
		if(!tokens.peek().matches(liststart))
			throw new ParserError("see " + tokens.poll() + ", expected [ here!" );
		skip(tokens);
		while(!isEnd(tokens) && !tokens.peek().matches(listend)){
			result = parseRepeat(iter, tokens);
		}
		if(isEnd(tokens) || !tokens.poll().matches(listend))
			throw new ParserError("Expected ] here !");
		if(!isEnd(tokens))
			throw new ParserError("Unnecessary long command input!");
		return result;
	}
	
	private double parseRepeat(int iter, Queue<String> qu) throws ParserError{
		double result = -1; //make more Treeparser.parse(Queue, String, int i);
		Node n = tParser.parse(qu);
		System.out.println("Tree parsed is " + n);
		for(int i=0; i < iter; i++ ){
			result = n.getValue();		//execute tree for # iterations	
		}		
		return result;
	}
	
	public static void main(String[] args) throws IOException, ParserError {
		RepeatParser example = new RepeatParser();	
		String repeat = "repeat 10 [ sum tan 50 10 ]";
		example.parse(repeat);
	}

}
