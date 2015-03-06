package configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import configuration.NestedParser.Match;
import configuration.NestedParser.ParserError;
import configuration.NestedParser.TreeParser;

public class IfelseParser extends Configuration{
	private TreeParser tParser;
	
	public IfelseParser() throws IOException{
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
	
	private double parse(Queue<String> tokens) throws ParserError {
		
	}
	public static void main(String[] args) {
		
		String ifelse = "ifelse equal? 2 6 [ rt 50 ] [ lt 50 ]";
	}
	
}
